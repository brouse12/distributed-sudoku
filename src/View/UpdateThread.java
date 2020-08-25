package View;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

import Controller.GroupComm.Messenger;
import Controller.GroupComm.UpdateMessage;
import Controller.Outcome;
import Model.Move;

/**
 * Worker thread to update the view in the background, outside of the normal event dispatch thread.
 * Use when the view must be updated due to an incoming message rather than client input via the
 * GUI.
 */
public class UpdateThread<A> extends SwingWorker<Move, Void> {

  private Move move;
  private boolean gameOver;
  private boolean checkComplete;
  private View view;
  private Messenger<A> messenger;
  private boolean broadcastChange;

  public UpdateThread(
          Move move, boolean gameOver, boolean checkComplete, View view, Messenger<A> messenger,
          boolean broadcastChange) {
    this.move = move;
    this.gameOver = gameOver;
    this.checkComplete = checkComplete;
    this.view = view;
    this.messenger = messenger;
    this.broadcastChange = broadcastChange;
  }

  /**
   * Pass the move update to the event dispatch thread, which will call done().  If a messenger is
   * provided, then the update should be broadcast to all nodes.
   */
  @Override
  protected Move doInBackground() {
    if (broadcastChange) {
      UpdateMessage message = new UpdateMessage(move);
      try {
        messenger.broadcastMessage(message);
      } catch (IOException e) {
        System.err.println("Exception while broadcasting master update with sequence: " +
                move.sequenceNum + " row: " + move.row + " col: " + move.col + ": " + e.getMessage());
      }
    }
    if (gameOver || checkComplete) {
      messenger.leaveGame();
    }
    return move;
  }

  /**
   * Method to be called by the event dispatch thread.  Update the view with the Move and resolve
   * outcomes as applicable.
   */
  @Override
  protected void done() {
    Move move = null;
    try {
      move = get(); // Get the move from the update thread
    } catch (InterruptedException | ExecutionException e) {
      System.err.println("Exception during background update of View: ");
      e.printStackTrace();
    }
    if (move != null) {
      view.update(move.num, move.row, move.col);
      if (gameOver) {
        view.shareOutcome(Outcome.CORRECT);
      } else if (checkComplete) {
        view.shareOutcome(Outcome.INCORRECT);
      }
    }
  }
}
