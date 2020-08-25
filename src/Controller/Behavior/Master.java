package Controller.Behavior;


import java.io.IOException;

import Controller.GroupComm.Messenger;
import Controller.GroupComm.UnicastThread;
import Controller.GroupComm.UpdateMessage;
import Controller.Outcome;
import Model.BoardState;
import Model.Model;
import Model.Level;
import Model.Move;
import View.UpdateThread;
import View.View;

public class Master<A> implements Behavior<A> {

  private Messenger<A> messenger;
  private Model model;
  private View view;

  public Master(Messenger<A> messenger, Model model, View view) {
    this.messenger = messenger;
    this.model = model;
    this.view = view;
    System.out.println("This is now the master node.");
  }

  @Override
  public void getPuzzle(Level level) {
    this.model.generatePuzzle(level);
  }

  @Override
  public void proposeMove(Move move) {
    int newSeqNum = model.playNumber(move);
    if (newSeqNum < 0) {
      return; // Move was invalid.
    }

    move.sequenceNum = newSeqNum;
    UpdateMessage update = new UpdateMessage(move);
    try {
      messenger.broadcastMessage(update);
    } catch (IOException e) {
      System.err.println("Exception while broadcasting master update with sequence: " + newSeqNum +
              " row: " + move.row + " col: " + move.col + ": " + e.getMessage());
    }

    // Update the board and determine if game is over
    this.view.update(move.num, move.row, move.col);
    if (gameOver()) {
      this.view.shareOutcome(Outcome.CORRECT);
      this.messenger.leaveGame();
    } else if (this.model.checkComplete()) {
      this.view.shareOutcome(Outcome.INCORRECT);
      this.messenger.leaveGame();
    }
  }

  @Override
  public void processBoardRequest(A senderAddress) {
    UpdateMessage message = new UpdateMessage(model.getBoardState());
    UnicastThread<A> sendBoard = new UnicastThread<>(messenger, senderAddress, message);
    sendBoard.start();
  }

  @Override
  public void processBoardStateUpdate(A senderAddress, BoardState state) {
    // Do nothing. Only the master can send a full board state update.
  }

  @Override
  public void processMoveUpdate(A senderAddress, Move move) {
    // Call function to play the number
    int newSeqNum = this.model.playNumber(move);
    // If the number was not played, return to calling function
    if (newSeqNum < 0) {
      UpdateMessage rejected = UpdateMessage.generateRejectMessage();
      UnicastThread<A> sendRejection = new UnicastThread<>(messenger, senderAddress, rejected);
      sendRejection.start();
      return;
    }
    move.sequenceNum = newSeqNum;
    boolean gameOver = gameOver();
    boolean checkComplete = model.checkComplete();
    UpdateThread<A> update = new UpdateThread<A>(
            move, gameOver, checkComplete, view, messenger, true);
    update.execute();
  }

  @Override
  public void processUpdateRejection() {
    System.err.println("Warning: A player has rejected this master's move update.");
  }

  private boolean gameOver() {
    if (this.model.checkComplete()) {
      return this.model.checkCorrect();
    } else {
      return false;
    }
  }

  @Override
  public void processMembershipChange(A[] members) {
    if (!members[0].equals(messenger.getMyAddress())) {
      System.err.println(
              "Fatal Warning: This master's position is not reflected in the group View.");
    }
  }
}
