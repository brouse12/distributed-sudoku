package Controller.GroupComm;

import java.io.Serializable;

import Model.BoardState;
import Model.Move;

/**
 * Represents a message to be sent via group communication.  Depending on the constructor called,
 * this can be a new move, the full board state, or a request for the board state.
 */
public class UpdateMessage implements Serializable {
  MessageType type; // Type of message
  Move move; // A move on a single square
  BoardState state; // The state of the whole board

  public UpdateMessage(BoardState state) {
    this.type = MessageType.BOARD;
    this.move = null;
    this.state = state;
  }

  public UpdateMessage(Move move) {
    this.type = MessageType.MOVE;
    this.move = move;
    this.state = null;
  }

  private UpdateMessage(MessageType type) {
    this.type = type;
    this.move = null;
    this.state = null;
  }

  public static UpdateMessage generateBoardRequest(){
    return new UpdateMessage(MessageType.BOARD_REQUEST);
  }

  public static UpdateMessage generateRejectMessage() {
    return new UpdateMessage(MessageType.UPDATE_REJECTED);
  }


    public MessageType getType() {
    return type;
  }

  public Move getMove() {
    return move;
  }

  public BoardState getState() {
    return state;
  }

  public enum MessageType {
    MOVE,
    BOARD,
    BOARD_REQUEST,
    UPDATE_REJECTED
  }
}
