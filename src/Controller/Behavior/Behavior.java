package Controller.Behavior;

import Model.BoardState;
import Model.Level;
import Model.Move;

public interface Behavior<A> {

  void getPuzzle(Level level);

  void proposeMove(Move move);

  void processMoveUpdate(A senderAddress, Move move);

  void processBoardStateUpdate(A senderAddress, BoardState state);

  void processBoardRequest(A senderAddress);

  void processUpdateRejection();

  void processMembershipChange(A[] members);
}
