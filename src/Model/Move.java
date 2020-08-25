package Model;

import java.io.Serializable;

/**
 * Data structure to encapsulate the fields in a move on the board.
 */
public class Move implements Serializable {
  public Players num;
  public int row;
  public int col;
  public int sequenceNum;

  public Move(Players num, int row, int col, int sequenceNum) {
    this.num = num;
    this.row = row;
    this.col = col;
    this.sequenceNum = sequenceNum;
  }
}
