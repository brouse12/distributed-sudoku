package Model;

import Controller.Constants;

public class Model {

    private int ROWS = Constants.getRows();
    private int COLS = Constants.getCols();
    private int NEEDED = Constants.getNeeded() + 1;
    private Level level = Level.EASY;

    private Players[][] grid = null;
    private Players[][] original = null;
    private Players[][] solution = null;
    private int sequenceNum = 0; // Each move increments the sequence number, tracking game progress

    public void generatePuzzle(Level level){
        Puzzles puzzleSet = new Puzzles(level);
        grid = puzzleSet.get_puzzle();
        original = puzzleSet.get_puzzle();
        solution = puzzleSet.get_solution();
        updateNeeded();
    }

    public synchronized void setPuzzle(BoardState state){
        if (state.sequenceNumber < this.sequenceNum){
            return; // This is old news.
        }
        this.grid = state.grid;
        this.original = state.original;
        this.solution = state.solution;
        this.sequenceNum = state.sequenceNumber;
        updateNeeded();
    }

    private void updateNeeded(){
        for(int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLS; j++){
                if(this.grid[i][j] != Players.EMPTY){
                    this.NEEDED--;
                }
            }
        }
    }

    public int getSequenceNum() {
        return sequenceNum;
    }

    public synchronized BoardState getBoardState(){
        return new BoardState(sequenceNum, grid, original, solution);
    }

    /**
     * This method is used to get the status of a cell specified by row and col.
     * @param row The row we are looking for information from
     * @param col The col we are looking for information from
     * @return Player. The status of the cell specified
     */
    public synchronized Players getStatus(int row, int col){
        // Confirm desired space is on the board
        if((row < 0) || (col < 0) || (row > (ROWS - 1)) || (col > (COLS - 1))){
            return Players.INVALID;
        }else if(this.original[row][col] != Players.EMPTY){
            return Players.INVALID;
        } else{
            return this.grid[row][col];
        }
    }

    /**
     * This method is used to play the next piece.
     * @param move The number, row, column, and sequence number that is being used
     * @return The new sequence number when the piece is played, -1 if error occurred
     */
    public synchronized int playNumber(Move move){
        if (move.sequenceNum < this.sequenceNum){
            return -1; // This is old news.
        }

        // Confirm the chosen cell is within the board
        Players status = getStatus(move.row, move.col);
        if (status != Players.INVALID) {
            this.grid[move.row][move.col] = move.num;
            this.NEEDED--;
            this.sequenceNum = move.sequenceNum > sequenceNum ? move.sequenceNum : sequenceNum + 1;
            return sequenceNum;
        }
        return -1;
    }

    public boolean checkComplete(){
        return (this.NEEDED == 0);
    }

    /**
     * This method is used to determine if the puzzle is correct
     * @return boolean. Determines if the correct values were input
     */
    public synchronized boolean checkCorrect(){
        // Check for winner by row, col, and up/down diagonally
        for(int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLS; j++){
                if(this.grid[i][j] != this.solution[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
