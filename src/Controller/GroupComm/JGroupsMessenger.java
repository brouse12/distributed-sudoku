package Controller.GroupComm;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.Receiver;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import Controller.Controller;

/**
 * An implementation of the Messenger interface using JGroups.  The address type should be
 * instantiated as org.jgroups.Address.  Assignment6/conf/message_protocols.xml should specify the
 * protocols to be used.
 *
 * @param <A> org.jgroups.Address
 */
public class JGroupsMessenger<A> implements Messenger<A> {

  private JChannel channel;

  public JGroupsMessenger(Controller<A> controller) throws Exception {
    String path = this.getClass().getClassLoader().getResource(
            "message_protocols.xml").toExternalForm();
    this.channel = new JChannel(path);
    this.channel.setDiscardOwnMessages(true);
    Receiver receiver = new JGroupsReceiver<A>(controller);
    channel.setReceiver(receiver);
  }

  @Override
  public void joinGame(String gameName) throws IllegalArgumentException {
    try {
      channel.connect(gameName);
    } catch (Exception e) {
      throw new IllegalArgumentException("Could not join game with name: " + gameName);
    }
  }

  @Override
  public void leaveGame() {
    channel.close();
    System.out.println("Exiting the game.");
  }

  @Override
  public void unicastMessage(UpdateMessage message, A address) throws IOException {
    Address jgroupsAddr = (Address) address;
    Message jMessage = new Message(jgroupsAddr, message);
    try {
      channel.send(jMessage);
    } catch (Exception e) {
      throw new IOException("Send Error: " + e.getMessage());
    }
  }

  @Override
  public void broadcastMessage(UpdateMessage message) throws IOException {
    Message jMessage = new Message(null, message);
    try {
      channel.send(jMessage);
    } catch (Exception e) {
      throw new IOException("Send Error: " + e.getMessage());
    }
  }

  @Override
  public void requestBoard() throws IOException {
    UpdateMessage boardRequest = UpdateMessage.generateBoardRequest();
    try {
      channel.send(null, boardRequest);
    } catch (Exception e) {
      throw new IOException("Send Error: " + e.getMessage());
    }
  }

  @Override
  public int getGroupSize() {
    return channel.getView().size();
  }

  @Override
  public A getMyAddress() {
    A myAddress = (A) channel.getAddress();
    return myAddress;
  }
}
