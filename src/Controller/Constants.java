package Controller;

/**
 * This class was created for easy adaptability of the game to different models
 * Any updates made here will reflect across the full game
 * Please note, the methodology is still written for Connect 4 style gameplay
 */
public class Constants {

    private static int ROWS = 9;
    private static int COLS = 9;
    private static int NEEDED = 80;
    private static int TITLE_BAR = 23;
    private static int CELL_SIZE = 50;
    private static String TITLE = "Sudoku";

    public Constants(){}

    public static int getCols(){return COLS;}

    public static int getRows(){return ROWS;}

    public static int getNeeded(){return NEEDED;}

    public static int getTitleBar(){return TITLE_BAR;}

    public static int getCellSize(){return CELL_SIZE;}

    public static String getTITLE(){return TITLE;}
}
