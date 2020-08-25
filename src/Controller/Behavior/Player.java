package Controller.Behavior;

import java.io.IOException;

import Controller.Controller;
import Controller.GroupComm.Messenger;
import Controller.GroupComm.UpdateMessage;
import Model.BoardState;
import Model.Model;
import Model.Level;
import Model.Move;
import Model.Players;
import View.UpdateThread;
import View.View;

public class Player<A> implements Behavior<A> {

  private A masterAddress = null;
  private boolean awaitingMasterResponse = false;
  private Messenger<A> messenger;
  private Model model;
  private View view;
  private Controller<A> controller;

  public Player(Messenger<A> messenger, Model model, View view, Controller<A> controller) {
    this.messenger = messenger;
    this.model = model;
    this.view = view;
    this.controller = controller;
    System.out.println(
            "Joined game as a player node with " + messenger.getGroupSize() + " total players.");
  }

  @Override
  public void getPuzzle(Level level) {
    try {
      messenger.requestBoard();
      waitForMasterResponse();
    } catch (IOException e) {
      throw new IllegalStateException("Could not broadcast initial board request to the group.");
    }
  }

  private void waitForMasterResponse() {
    awaitingMasterResponse = true;
    while (awaitingMasterResponse) {
      // Do nothing.
      try {
        Thread.sleep(5);
      } catch (InterruptedException e) {
        // do nothing.
      }
    }
  }

  @Override
  public void proposeMove(Move move) {
    if (model.getStatus(move.row, move.col) == Players.INVALID) {
      return;
    }
    UpdateMessage proposal = new UpdateMessage(move);
    try {
      messenger.unicastMessage(proposal, masterAddress);
      waitForMasterResponse();
    } catch (IOException e) {
      System.err.println("Exception while messaging proposed move with sequence: " +
              move.sequenceNum + " row: " + move.row + " col: " + move.col + ":" + e.getMessage());
    }
  }

  @Override
  public void processBoardRequest(A senderAddress) {
    // Do nothing. Players do not own the master board.
  }

  @Override
  public void processBoardStateUpdate(A senderAddress, BoardState state) {
    if (state.sequenceNumber < model.getSequenceNum()) {
      return; // This is old news.
    }
    model.setPuzzle(state);
    masterAddress = senderAddress;
    awaitingMasterResponse = false;
  }

  @Override
  public void processMoveUpdate(A senderAddress, Move move) {
    if (!senderAddress.equals(masterAddress)) {
      System.err.println(
              "Warning: Received a move update from a non-master player: " + senderAddress.toString());
      return; // We received a message proposal from a random player.
    }
    // Call function to play the number
    int newSeqNum = this.model.playNumber(move);
    // If the number was not played, return to calling function
    if (newSeqNum < 0) {
      System.err.println("Rejected update from master with sequence number: " + move.sequenceNum);
      return;
    }
    boolean gameOver = gameOver();
    boolean checkComplete = model.checkComplete();
    UpdateThread<A> update = new UpdateThread<A>(
            move, gameOver, checkComplete, view, messenger, false);
    update.execute();
    awaitingMasterResponse = false;
  }

  @Override
  public void processUpdateRejection() {
    awaitingMasterResponse = false;
  }

  private boolean gameOver() {
    if (this.model.checkComplete()) {
      return this.model.checkCorrect();
    } else {
      return false;
    }
  }

  @Override
  public synchronized void processMembershipChange(A[] members) {
    if (!members[0].equals(masterAddress)) {
      // The master is dead. Long live the master.
      masterAddress = members[0];
      awaitingMasterResponse = false;
      if (masterAddress.equals(messenger.getMyAddress())) {
        // We're the master now.
        controller.changeToMasterBehavior();
      }
    }
  }
}
