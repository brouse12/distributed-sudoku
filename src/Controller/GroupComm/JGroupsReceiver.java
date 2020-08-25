package Controller.GroupComm;

import org.jgroups.Address;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

import Controller.Controller;

/**
 * This class receives incoming JGroups messages on a thread separate from the main execution, and
 * uses callback methods from the Controller to handle them as needed.  Callback methods should not
 * block and any objects accessed through this class's methods may require synchronization.
 *
 * @param <A> org.jgroups.address
 */
public class JGroupsReceiver<A> extends ReceiverAdapter {
  private Controller<A> controller;

  public JGroupsReceiver(Controller<A> controller) {
    this.controller = controller;
  }

  @Override
  public void receive(Message msg) {
    UpdateMessage message = msg.getObject();
    Address senderAddress = msg.getSrc();
    A address = (A) senderAddress; // Convert to dynamic address type, which should be the same.
    System.out.println(
            "Received " + message.type.name() + " message from address " + senderAddress);

    switch (message.getType()) {
      case MOVE:
        waitUntilControllerRunning();
        controller.getBehavior().processMoveUpdate(address, message.getMove());
        break;

      case BOARD:
        if (controller.isRunning()) {
          return; // Board state is only updated in the constructor.
        }
        controller.getBehavior().processBoardStateUpdate(address, message.getState());
        break;

      case BOARD_REQUEST:
        waitUntilControllerRunning();
        controller.getBehavior().processBoardRequest(address);
        break;

      case UPDATE_REJECTED:
        controller.getBehavior().processUpdateRejection();
    }
  }

  private void waitUntilControllerRunning() {
    while (!controller.isRunning()) {
      try {
        Thread.sleep(5);
      } catch (InterruptedException e) {
        // do nothing.
      }
    }

  }

  @Override
  public void viewAccepted(View view) {
    if (controller.getBehavior() != null) {
      A[] members = (A[]) view.getMembersRaw();
      controller.getBehavior().processMembershipChange(members);
    }
  }
}
