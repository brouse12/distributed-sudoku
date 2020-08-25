package View;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import Controller.Constants;
import Controller.Controller;
import Controller.Outcome;
import Model.BoardState;
import Model.Level;
import Model.Players;

public class WindowView<A> extends JPanel implements View, KeyListener {

    private static final int TITLE_BAR = Constants.getTitleBar();
    private static final int CELL_SIZE = Constants.getCellSize();
    private static String TITLE = Constants.getTITLE();
    private static int ROWS = Constants.getRows();
    private static int COLS = Constants.getCols();
    private static int rowSize(){return CELL_SIZE * ROWS;}
    private static int colSize(){return CELL_SIZE * COLS;}

    private Players[][] grid = null;
    private Players[][] original = null;
    private Outcome outcome = null;
    private Controller<A> controller;
    private JFrame window = null;
    private int curRow = -1;
    private int curCol = -1;
    private Players number = Players.EMPTY;
    private boolean gameOver = false;
    private Graphics g = null;
    private Level level = Level.EASY;

    /**
     * This is the constructor. Used to set up the needed object variables.
     * @return Nothing.
     */
    public WindowView(Controller<A> controller){
        this.controller = controller;
    }

    @Override
    public void setup(BoardState state) {
        this.grid = state.grid;
        this.original = state.original;
        this.outcome = Outcome.PENDING;
        makeWindow();
        this.window.addKeyListener(this);
    }

    /**
     * This method is used to create the window image to play the game
     * @return Nothing.
     */
    private void makeWindow(){
        this.window = new JFrame(TITLE);
        this.window.setContentPane(this);
        this.window.setSize(colSize() + 17,TITLE_BAR + rowSize() + 17);
        this.window.setVisible(true);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set the outcome so it can be shown to the user
     * @param outcome The outcome/status of the game
     * @return Nothing.
     */
    public void shareOutcome(Outcome outcome) {
        this.outcome = outcome;
        this.gameOver = true;
    }

    /**
     * This method is used to update the grid to reflect the turns
     * @param turn The player whose turn it is (color of piece)
     * @param row The row that the piece should be played at
     * @param col The col that the piece should be played at
     * @return Nothing.
     */
    public void update(Players turn, int row, int col) {
        this.grid[row][col] = turn;
        // Calls the paint component function to update the grid
        this.repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.g = g;
        Graphics2D g2 = (Graphics2D) g;
        paintGridLines(g2);
        paintCursor(g);
        paintGrid(g);
        paintOutcome(g);
    }

    /**
     * This method is used to display the lines on the window view
     * @param g The graphics module for the board
     * @return Nothing.
     */
    private static void paintGridLines(Graphics2D g){
        int yTop = 0;
        int yBottom = rowSize();
        int xLeft = 0;
        int xRight = colSize();

        // Draw vertical lines
        for(int i = 1; i < COLS; i++){
            if((i % 3) == 0){
                g.setStroke(new BasicStroke(3));
            }
            g.drawLine(xLeft+(i*CELL_SIZE),yTop,xLeft+(i*CELL_SIZE),yBottom);
            g.setStroke(new BasicStroke(1));
        }

        // Draw horizontal lines
        for(int i = 1; i < ROWS; i++){
            if((i % 3) == 0){
                g.setStroke(new BasicStroke(3));
            }
            g.drawLine(xLeft,yTop+(i*CELL_SIZE),xRight,yTop+(i*CELL_SIZE));
            g.setStroke(new BasicStroke(1));
        }
    }

    /**
     * This method is used to display the selected column
     * @param g The graphics module for the board
     * @return Nothing.
     */
    private void paintCursor(Graphics g){
        int x = this.curCol * CELL_SIZE;
        int y = this.curRow * CELL_SIZE;
        Color currentColor = g.getColor();
        g.setColor(Color.PINK);
        g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
        g.setColor(currentColor);
    }

    /**
     * This method is used to paint the grid with the updated turns
     * @param g The graphics module for the board
     * @return Nothing.
     */
    private void paintGrid(Graphics g){
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                switch (this.grid[i][j]) {
                    case ONE:
                        paintNumber(g, 1, j, i);
                        break;
                    case TWO:
                        paintNumber(g, 2, j, i);
                        break;
                    case THREE:
                        paintNumber(g, 3, j, i);
                        break;
                    case FOUR:
                        paintNumber(g, 4, j, i);
                        break;
                    case FIVE:
                        paintNumber(g, 5, j, i);
                        break;
                    case SIX:
                        paintNumber(g, 6, j, i);
                        break;
                    case SEVEN:
                        paintNumber(g, 7, j, i);
                        break;
                    case EIGHT:
                        paintNumber(g, 8, j, i);
                        break;
                    case NINE:
                        paintNumber(g, 9, j, i);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * This method is used to update the grid to reflect a blue piece played
     * @param g The graphics module for the board
     * @param num The number to write to the board
     * @param j The row that the piece should be played at
     * @param i The col that the piece should be played at
     * @return Nothing.
     */
    private void paintNumber(Graphics g, int num, int j, int i){
        int x = j * CELL_SIZE;
        int y = i * CELL_SIZE + CELL_SIZE;
        int adjust = CELL_SIZE / 3;
        if(this.original[i][j] == Players.EMPTY){
            g.setColor(Color.BLUE);
        } else {
            g.setColor(Color.BLACK);
        }
        g.setFont(new Font("Britannic Bold", Font.PLAIN, adjust * 2));
        g.drawString(String.valueOf(num), x + adjust, y - adjust);
        g.setColor(Color.BLACK);
    }

    /**
     * This method is used to update the grid to reflect a red piece played
     * @param g The graphics module for the board
     * @param num The number to write to the board
     * @param y The row that the piece should be played at
     * @param x The col that the piece should be played at
     * @return Nothing.
     */
    private void paintOption(Graphics g, int num, int x, int y){
        int adjust = CELL_SIZE / 3;
        g.setColor(Color.RED);
        g.setFont(new Font("Britannic Bold", Font.PLAIN, adjust * 2));
        g.drawString(String.valueOf(num), x + adjust, y - adjust);
        g.setColor(Color.BLACK);
    }

    /**
     * This method is used to display the winner to the user
     * @param g The graphics module for the board
     * @return Nothing.
     */
    private void paintOutcome(Graphics g){
        // Set location for the words
        int x = rowSize() / 5;
        int y = colSize() / 2;

        // Set the font to display the winner
        g.setFont(new Font("Britannic Bold", Font.PLAIN, CELL_SIZE));

        // Display the appropriate words based on the winner
        switch (this.outcome){
            case CORRECT:
                g.drawString("CORRECT!", x, y);
                break;
            case INCORRECT:
                g.setColor(Color.RED);
                g.drawString("TRY AGAIN!", x, y);
                break;
            default:
                break;
        }
    }

    /**
     * These methods are used to read in key data from the user
     * @param e The key event recorded by the system
     * @return Nothing.
     */
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {
        // If game is over cursor should no longer move
        if(this.gameOver){
            return;
        }

        // Move the cursor(highlighted box) on the screen
        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                if (this.curCol > 0){
                    this.curCol--;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (this.curCol < COLS){
                    this.curCol++;
                }
                break;
            case KeyEvent.VK_UP:
                if (this.curRow > 0){
                    this.curRow--;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (this.curRow < ROWS){
                    this.curRow++;
                }
                break;
            case KeyEvent.VK_NUMPAD1:
            case KeyEvent.VK_1:
                this.number = Players.ONE;
                this.paintOption(this.g, 1, this.curRow * CELL_SIZE, this.curCol * CELL_SIZE);
                break;
            case KeyEvent.VK_NUMPAD2:
            case KeyEvent.VK_2:
                this.number = Players.TWO;
                this.paintOption(this.g, 2, this.curRow * CELL_SIZE, this.curCol * CELL_SIZE);
                break;
            case KeyEvent.VK_NUMPAD3:
            case KeyEvent.VK_3:
                this.number = Players.THREE;
                this.paintOption(this.g, 3, this.curRow * CELL_SIZE, this.curCol * CELL_SIZE);
                break;
            case KeyEvent.VK_NUMPAD4:
            case KeyEvent.VK_4:
                this.number = Players.FOUR;
                this.paintOption(this.g, 4, this.curRow * CELL_SIZE, this.curCol * CELL_SIZE);
                break;
            case KeyEvent.VK_NUMPAD5:
            case KeyEvent.VK_5:
                this.number = Players.FIVE;
                this.paintOption(this.g, 5, this.curRow * CELL_SIZE, this.curCol * CELL_SIZE);
                break;
            case KeyEvent.VK_NUMPAD6:
            case KeyEvent.VK_6:
                this.number = Players.SIX;
                this.paintOption(this.g, 6, this.curRow * CELL_SIZE, this.curCol * CELL_SIZE);
                break;
            case KeyEvent.VK_NUMPAD7:
            case KeyEvent.VK_7:
                this.number = Players.SEVEN;
                this.paintOption(this.g, 7, this.curRow * CELL_SIZE, this.curCol * CELL_SIZE);
                break;
            case KeyEvent.VK_NUMPAD8:
            case KeyEvent.VK_8:
                this.number = Players.EIGHT;
                this.paintOption(this.g, 8, this.curRow * CELL_SIZE, this.curCol * CELL_SIZE);
                break;
            case KeyEvent.VK_NUMPAD9:
            case KeyEvent.VK_9:
                this.number = Players.NINE;
                this.paintOption(this.g, 9, this.curRow * CELL_SIZE, this.curCol * CELL_SIZE);
                break;
            case KeyEvent.VK_ENTER:
                this.controller.takeTurn(this.number, this.curRow, this.curCol);
                break;
            default:
                break;
        }

        // Update the board according to the user selection
        repaint();
    }
}
