package Controller;

import org.jgroups.Address;

import Controller.Behavior.Behavior;
import Controller.Behavior.Master;
import Controller.Behavior.Player;
import Controller.GroupComm.JGroupsMessenger;
import Controller.GroupComm.Messenger;
import Model.Level;
import Model.Model;
import Model.Move;
import Model.Players;
import View.StartScreen;
import View.View;
import View.WindowView;

/**
 * Central Sudoku game logic.
 */
public class Controller<A> {

  private Model model;
  private View view;
  private Messenger<A> messenger;
  private Behavior<A> behavior;
  private boolean running;
  private String gameName = "DEFAULT";
  private Level level = Level.EASY;
  private boolean inputsSet = false;

  /**
   * This is the constructor. Used to set up the needed object variables.
   *
   * @return Nothing.
   */
  public Controller(Model model) {
    this.model = model;
    this.view = new WindowView<A>(this);
    this.messenger = null;
    this.behavior = null;
    this.running = false;
  }

  public void setGameName(String gameName) {
    this.gameName = gameName;
  }

  public void setLevel(Level level) {
    this.level = level;
    this.inputsSet = true;
  }

  private void setMessenger(Messenger<A> messenger) {
    this.messenger = messenger;
  }

  private void start() throws InterruptedException {
    StartScreen inputs = new StartScreen(this);
    inputs.start();
    while (!inputsSet) {
      Thread.sleep(1000);
    }
    messenger.joinGame(this.gameName);
    behavior = messenger.getGroupSize() == 1 ?
            new Master<A>(messenger, model, view) : new Player<A>(messenger, model, view, this);
    behavior.getPuzzle(this.level);
    view.setup(model.getBoardState());
    running = true;
  }

  public boolean isRunning() {
    return running;
  }

  public Behavior<A> getBehavior() {
    return behavior;
  }

  /**
   * This method is used to take a turn
   *
   * @param num The number to be played on the board
   * @param row The row of the number to be played
   * @param col The column of the number to be played
   * @return Nothing.
   */
  public void takeTurn(Players num, int row, int col) throws IllegalStateException {
    Move move = new Move(num, row, col, model.getSequenceNum());
    this.behavior.proposeMove(move);
  }

  public void changeToMasterBehavior() {
    this.behavior = new Master<A>(messenger, model, view);
  }

  /**
   * This is the main function. Used to start the game.
   *
   * @return Nothing.
   */
  public static void main(String[] args) {
    Model model = new Model();
    try {
      Controller<Address> controller = new Controller<Address>(model);
      Messenger<Address> messenger = new JGroupsMessenger<Address>(controller);
      controller.setMessenger(messenger);
      controller.start();
    } catch (Exception e) {
      System.err.println("Error thrown: " + e.getMessage());
      e.printStackTrace();
      System.exit(1);
    }
  }
}
