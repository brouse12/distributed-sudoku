package View;

import Controller.Outcome;
import Model.Players;
import Model.BoardState;

public interface View {
    void shareOutcome(Outcome outcome);
    void update(Players turn, int row, int col);
    void setup(BoardState state);
}
