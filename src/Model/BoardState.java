package Model;

import java.io.Serializable;

/**
 * Data structure encapsulating the board's full state.
 */
public class BoardState implements Serializable {
  public int sequenceNumber;
  public Players[][] grid;
  public Players[][] original;
  public Players[][] solution;

  public BoardState(
          int sequenceNumber, Players[][] grid, Players[][] original, Players[][] solution) {
    this.sequenceNumber = sequenceNumber;
    this.grid = grid;
    this.original = original;
    this.solution = solution;
  }
}
