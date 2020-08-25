package Controller.GroupComm;

import java.io.IOException;

/**
 * Separate thread for unicasting a message using a group communication tool that implements
 * Messenger. Note: JGroups docs specify that the Receiver should send its messages in a separate
 * thread to avoid blocking.
 *
 * @param <A> the host address type
 */
public class UnicastThread<A> extends Thread {

  private Messenger<A> messenger;
  private A address;
  private UpdateMessage message;

  public UnicastThread(Messenger<A> messenger, A address, UpdateMessage message) {
    this.messenger = messenger;
    this.address = address;
    this.message = message;
  }

  @Override
  public void run() {
    try {
      messenger.unicastMessage(message, address);
    } catch (IOException e) {
      System.err.println(
              "Exception while sending " + message.getType() + " message: " + e.getMessage());
    }
  }
}
