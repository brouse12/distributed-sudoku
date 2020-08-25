package Controller.GroupComm;

import java.io.IOException;

/**
 * Interface for a group communication messenger that will handle communication with the other
 * players.
 *
 * @param <A> the object type representing a player's Address for the particular group communication
 *            implementation.
 */
public interface Messenger<A> {

  void joinGame(String gameName) throws IllegalArgumentException;

  void leaveGame();

  void unicastMessage(UpdateMessage message, A address) throws IOException;

  void broadcastMessage(UpdateMessage message) throws IOException;

  void requestBoard() throws IOException;

  int getGroupSize();

  A getMyAddress();
}
