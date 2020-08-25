package Model;

import java.util.ArrayList;
import java.util.Random;

public class Puzzles {
    private Players[][] e1_solution = {
            {Players.TWO, Players.NINE, Players.SIX, Players.ONE, Players.FOUR, Players.FIVE, Players.EIGHT, Players.THREE, Players.SEVEN},
            {Players.THREE, Players.FIVE, Players.SEVEN, Players.EIGHT, Players.TWO, Players.SIX, Players.ONE, Players.FOUR, Players.NINE},
            {Players.ONE, Players.FOUR, Players.EIGHT, Players.NINE, Players.THREE, Players.SEVEN, Players.FIVE, Players.TWO, Players.SIX},
            {Players.SIX, Players.THREE, Players.NINE, Players.FIVE, Players.ONE, Players.TWO, Players.FOUR, Players.SEVEN, Players.EIGHT},
            {Players.FIVE, Players.EIGHT, Players.ONE, Players.SEVEN, Players.SIX, Players.FOUR, Players.THREE, Players.NINE, Players.TWO},
            {Players.FOUR, Players.SEVEN, Players.TWO, Players.THREE, Players.NINE, Players.EIGHT, Players.SIX, Players.ONE, Players.FIVE},
            {Players.NINE, Players.SIX, Players.FOUR, Players.TWO, Players.EIGHT, Players.THREE, Players.SEVEN, Players.FIVE, Players.ONE},
            {Players.EIGHT, Players.ONE, Players.FIVE, Players.FOUR, Players.SEVEN, Players.NINE, Players.TWO, Players.SIX, Players.THREE},
            {Players.SEVEN, Players.TWO, Players.THREE, Players.SIX, Players.FIVE, Players.ONE, Players.NINE, Players.EIGHT, Players.FOUR}
    };
    private Players[][] e2_solution = {
            {Players.ONE, Players.SIX, Players.SEVEN, Players.FIVE, Players.TWO, Players.FOUR, Players.NINE, Players.THREE, Players.EIGHT},
            {Players.TWO, Players.THREE, Players.NINE, Players.ONE, Players.SEVEN, Players.EIGHT, Players.SIX, Players.FIVE, Players.FOUR},
            {Players.EIGHT, Players.FIVE, Players.FOUR, Players.THREE, Players.NINE, Players.SIX, Players.TWO, Players.SEVEN, Players.ONE},
            {Players.SIX, Players.NINE, Players.EIGHT, Players.SEVEN, Players.FOUR, Players.TWO, Players.THREE, Players.ONE, Players.FIVE},
            {Players.SEVEN, Players.TWO, Players.THREE, Players.SIX, Players.ONE, Players.FIVE, Players.FOUR, Players.EIGHT, Players.NINE},
            {Players.FIVE, Players.FOUR, Players.ONE, Players.EIGHT, Players.THREE, Players.NINE, Players.SEVEN, Players.SIX, Players.TWO},
            {Players.THREE, Players.ONE, Players.TWO, Players.FOUR, Players.EIGHT, Players.SEVEN, Players.FIVE, Players.NINE, Players.SIX},
            {Players.NINE, Players.SEVEN, Players.SIX, Players.TWO, Players.FIVE, Players.ONE, Players.EIGHT, Players.FOUR, Players.THREE},
            {Players.FOUR, Players.EIGHT, Players.FIVE, Players.NINE, Players.SIX, Players.THREE, Players.ONE, Players.TWO, Players.SEVEN}
    };
    private Players[][] e3_solution = {
            {Players.ONE, Players.EIGHT, Players.FIVE, Players.SEVEN, Players.FOUR, Players.NINE, Players.TWO, Players.THREE, Players.SIX},
            {Players.SEVEN, Players.NINE, Players.FOUR, Players.TWO, Players.SIX, Players.THREE, Players.EIGHT, Players.FIVE, Players.ONE},
            {Players.THREE, Players.SIX, Players.TWO, Players.EIGHT, Players.ONE, Players.FIVE, Players.SEVEN, Players.FOUR, Players.NINE},
            {Players.NINE, Players.FOUR, Players.SEVEN, Players.ONE, Players.THREE, Players.EIGHT, Players.FIVE, Players.SIX, Players.TWO},
            {Players.FIVE, Players.TWO, Players.ONE, Players.NINE, Players.SEVEN, Players.SIX, Players.THREE, Players.EIGHT, Players.FOUR},
            {Players.EIGHT, Players.THREE, Players.SIX, Players.FIVE, Players.TWO, Players.FOUR, Players.ONE, Players.NINE, Players.SEVEN},
            {Players.SIX, Players.ONE, Players.THREE, Players.FOUR, Players.FIVE, Players.TWO, Players.NINE, Players.SEVEN, Players.EIGHT},
            {Players.TWO, Players.FIVE, Players.EIGHT, Players.SIX, Players.NINE, Players.SEVEN, Players.FOUR, Players.ONE, Players.THREE},
            {Players.FOUR, Players.SEVEN, Players.NINE, Players.THREE, Players.EIGHT, Players.ONE, Players.SIX, Players.TWO, Players.FIVE}
    };
    private Players[][] e4_solution = {
            {Players.TWO, Players.NINE, Players.THREE, Players.ONE, Players.SEVEN, Players.FOUR, Players.EIGHT, Players.SIX, Players.FIVE},
            {Players.FIVE, Players.ONE, Players.EIGHT, Players.SIX, Players.TWO, Players.THREE, Players.FOUR, Players.SEVEN, Players.NINE},
            {Players.SIX, Players.SEVEN, Players.FOUR, Players.NINE, Players.EIGHT, Players.FIVE, Players.TWO, Players.THREE, Players.ONE},
            {Players.THREE, Players.EIGHT, Players.FIVE, Players.TWO, Players.NINE, Players.SIX, Players.ONE, Players.FOUR, Players.SEVEN},
            {Players.ONE, Players.SIX, Players.NINE, Players.EIGHT, Players.FOUR, Players.SEVEN, Players.FIVE, Players.TWO, Players.THREE},
            {Players.SEVEN, Players.FOUR, Players.TWO, Players.FIVE, Players.THREE, Players.ONE, Players.NINE, Players.EIGHT, Players.SIX},
            {Players.FOUR, Players.FIVE, Players.ONE, Players.SEVEN, Players.SIX, Players.EIGHT, Players.THREE, Players.NINE, Players.TWO},
            {Players.EIGHT, Players.TWO, Players.SIX, Players.THREE, Players.FIVE, Players.NINE, Players.SEVEN, Players.ONE, Players.FOUR},
            {Players.NINE, Players.THREE, Players.SEVEN, Players.FOUR, Players.ONE, Players.TWO, Players.SIX, Players.FIVE, Players.EIGHT}
    };
    private Players[][] m1_solution = {
            {Players.ONE, Players.NINE, Players.EIGHT, Players.SEVEN, Players.FIVE, Players.SIX, Players.FOUR, Players.THREE, Players.TWO},
            {Players.THREE, Players.TWO, Players.SIX, Players.ONE, Players.NINE, Players.FOUR, Players.EIGHT, Players.FIVE, Players.SEVEN},
            {Players.FIVE, Players.FOUR, Players.SEVEN, Players.THREE, Players.TWO, Players.EIGHT, Players.ONE, Players.SIX, Players.NINE},
            {Players.TWO, Players.SIX, Players.NINE, Players.FIVE, Players.ONE, Players.SEVEN, Players.THREE, Players.EIGHT, Players.FOUR},
            {Players.SEVEN, Players.ONE, Players.THREE, Players.FOUR, Players.EIGHT, Players.NINE, Players.FIVE, Players.TWO, Players.SIX},
            {Players.FOUR, Players.EIGHT, Players.FIVE, Players.SIX, Players.THREE, Players.TWO, Players.SEVEN, Players.NINE, Players.ONE},
            {Players.NINE, Players.THREE, Players.TWO, Players.EIGHT, Players.FOUR, Players.ONE, Players.SIX, Players.SEVEN, Players.FIVE},
            {Players.SIX, Players.FIVE, Players.FOUR, Players.NINE, Players.SEVEN, Players.THREE, Players.TWO, Players.ONE, Players.EIGHT},
            {Players.EIGHT, Players.SEVEN, Players.ONE, Players.TWO, Players.SIX, Players.FIVE, Players.NINE, Players.FOUR, Players.THREE}
    };
    private Players[][] m2_solution = {
            {Players.FOUR, Players.ONE, Players.SIX, Players.NINE, Players.TWO, Players.THREE, Players.FIVE, Players.EIGHT, Players.SEVEN},
            {Players.FIVE, Players.EIGHT, Players.TWO, Players.FOUR, Players.ONE, Players.SEVEN, Players.SIX, Players.NINE, Players.THREE},
            {Players.THREE, Players.NINE, Players.SEVEN, Players.SIX, Players.EIGHT, Players.FIVE, Players.FOUR, Players.ONE, Players.TWO},
            {Players.SEVEN, Players.THREE, Players.NINE, Players.ONE, Players.SIX, Players.FOUR, Players.TWO, Players.FIVE, Players.EIGHT},
            {Players.ONE, Players.FIVE, Players.EIGHT, Players.THREE, Players.SEVEN, Players.TWO, Players.NINE, Players.FOUR, Players.SIX},
            {Players.SIX, Players.TWO, Players.FOUR, Players.EIGHT, Players.FIVE, Players.NINE, Players.SEVEN, Players.THREE, Players.ONE},
            {Players.NINE, Players.SEVEN, Players.THREE, Players.TWO, Players.FOUR, Players.ONE, Players.EIGHT, Players.SIX, Players.FIVE},
            {Players.TWO, Players.SIX, Players.ONE, Players.FIVE, Players.NINE, Players.EIGHT, Players.THREE, Players.SEVEN, Players.FOUR},
            {Players.EIGHT, Players.FOUR, Players.FIVE, Players.SEVEN, Players.THREE, Players.SIX, Players.ONE, Players.TWO, Players.NINE}
    };
    private Players[][] m3_solution = {
            {Players.EIGHT, Players.FIVE, Players.THREE, Players.TWO, Players.FOUR, Players.ONE, Players.SIX, Players.NINE, Players.SEVEN},
            {Players.NINE, Players.FOUR, Players.TWO, Players.SIX, Players.FIVE, Players.SEVEN, Players.EIGHT, Players.ONE, Players.THREE},
            {Players.ONE, Players.SEVEN, Players.SIX, Players.NINE, Players.EIGHT, Players.THREE, Players.TWO, Players.FOUR, Players.FIVE},
            {Players.FIVE, Players.SIX, Players.NINE, Players.FOUR, Players.SEVEN, Players.TWO, Players.ONE, Players.THREE, Players.EIGHT},
            {Players.TWO, Players.THREE, Players.FOUR, Players.EIGHT, Players.ONE, Players.FIVE, Players.NINE, Players.SEVEN, Players.SIX},
            {Players.SEVEN, Players.EIGHT, Players.ONE, Players.THREE, Players.SIX, Players.NINE, Players.FOUR, Players.FIVE, Players.TWO},
            {Players.SIX, Players.NINE, Players.SEVEN, Players.FIVE, Players.TWO, Players.FOUR, Players.THREE, Players.EIGHT, Players.ONE},
            {Players.FOUR, Players.TWO, Players.FIVE, Players.ONE, Players.THREE, Players.EIGHT, Players.SEVEN, Players.SIX, Players.NINE},
            {Players.THREE, Players.ONE, Players.EIGHT, Players.SEVEN, Players.NINE, Players.SIX, Players.FIVE, Players.TWO, Players.FOUR}
    };
    private Players[][] m4_solution = {
            {Players.SIX, Players.ONE, Players.THREE, Players.SEVEN, Players.FIVE, Players.NINE, Players.EIGHT, Players.TWO, Players.FOUR},
            {Players.FOUR, Players.EIGHT, Players.NINE, Players.TWO, Players.ONE, Players.SIX, Players.THREE, Players.SEVEN, Players.FIVE},
            {Players.FIVE, Players.TWO, Players.SEVEN, Players.EIGHT, Players.THREE, Players.FOUR, Players.SIX, Players.ONE, Players.NINE},
            {Players.NINE, Players.SIX, Players.FIVE, Players.ONE, Players.SEVEN, Players.EIGHT, Players.FOUR, Players.THREE, Players.TWO},
            {Players.THREE, Players.SEVEN, Players.EIGHT, Players.FIVE, Players.FOUR, Players.TWO, Players.NINE, Players.SIX, Players.ONE},
            {Players.ONE, Players.FOUR, Players.TWO, Players.SIX, Players.NINE, Players.THREE, Players.SEVEN, Players.FIVE, Players.EIGHT},
            {Players.TWO, Players.FIVE, Players.FOUR, Players.NINE, Players.SIX, Players.SEVEN, Players.ONE, Players.EIGHT, Players.THREE},
            {Players.SEVEN, Players.NINE, Players.ONE, Players.THREE, Players.EIGHT, Players.FIVE, Players.TWO, Players.FOUR, Players.SIX},
            {Players.EIGHT, Players.THREE, Players.SIX, Players.FOUR, Players.TWO, Players.ONE, Players.FIVE, Players.NINE, Players.SEVEN}
    };
    private Players[][] h1_solution = {
            {Players.TWO, Players.THREE, Players.ONE, Players.FIVE, Players.SEVEN, Players.FOUR, Players.EIGHT, Players.NINE, Players.SIX},
            {Players.FOUR, Players.SEVEN, Players.FIVE, Players.SIX, Players.NINE, Players.EIGHT, Players.THREE, Players.ONE, Players.TWO},
            {Players.SIX, Players.EIGHT, Players.NINE, Players.ONE, Players.THREE, Players.TWO, Players.FOUR, Players.SEVEN, Players.FIVE},
            {Players.FIVE, Players.TWO, Players.SIX, Players.FOUR, Players.ONE, Players.THREE, Players.NINE, Players.EIGHT, Players.SEVEN},
            {Players.THREE, Players.FOUR, Players.SEVEN, Players.EIGHT, Players.FIVE, Players.NINE, Players.SIX, Players.TWO, Players.ONE},
            {Players.ONE, Players.NINE, Players.EIGHT, Players.TWO, Players.SIX, Players.SEVEN, Players.FIVE, Players.FOUR, Players.THREE},
            {Players.EIGHT, Players.FIVE, Players.FOUR, Players.SEVEN, Players.TWO, Players.SIX, Players.ONE, Players.THREE, Players.NINE},
            {Players.NINE, Players.SIX, Players.TWO, Players.THREE, Players.FOUR, Players.ONE, Players.SEVEN, Players.FIVE, Players.EIGHT},
            {Players.SEVEN, Players.ONE, Players.THREE, Players.NINE, Players.EIGHT, Players.FIVE, Players.TWO, Players.SIX, Players.FOUR}
    };
    private Players[][] h2_solution = {
            {Players.SIX, Players.ONE, Players.EIGHT, Players.TWO, Players.THREE, Players.SEVEN, Players.NINE, Players.FIVE, Players.FOUR},
            {Players.FIVE, Players.THREE, Players.FOUR, Players.SIX, Players.NINE, Players.EIGHT, Players.SEVEN, Players.TWO, Players.ONE},
            {Players.NINE, Players.TWO, Players.SEVEN, Players.ONE, Players.FOUR, Players.FIVE, Players.EIGHT, Players.THREE, Players.SIX},
            {Players.FOUR, Players.SIX, Players.THREE, Players.EIGHT, Players.SEVEN, Players.TWO, Players.ONE, Players.NINE, Players.FIVE},
            {Players.SEVEN, Players.FIVE, Players.NINE, Players.FOUR, Players.ONE, Players.SIX, Players.THREE, Players.EIGHT, Players.TWO},
            {Players.ONE, Players.EIGHT, Players.TWO, Players.NINE, Players.FIVE, Players.THREE, Players.FOUR, Players.SIX, Players.SEVEN},
            {Players.THREE, Players.SEVEN, Players.ONE, Players.FIVE, Players.TWO, Players.NINE, Players.SIX, Players.FOUR, Players.EIGHT},
            {Players.TWO, Players.FOUR, Players.SIX, Players.THREE, Players.EIGHT, Players.ONE, Players.FIVE, Players.SEVEN, Players.NINE},
            {Players.EIGHT, Players.NINE, Players.FIVE, Players.SEVEN, Players.SIX, Players.FOUR, Players.TWO, Players.ONE, Players.THREE}
    };
    private Players[][] h3_solution = {
            {Players.FIVE, Players.ONE, Players.FOUR, Players.TWO, Players.SEVEN, Players.EIGHT, Players.SIX, Players.NINE, Players.THREE},
            {Players.TWO, Players.THREE, Players.SEVEN, Players.SIX, Players.NINE, Players.ONE, Players.FOUR, Players.EIGHT, Players.FIVE},
            {Players.NINE, Players.EIGHT, Players.SIX, Players.FIVE, Players.FOUR, Players.THREE, Players.TWO, Players.ONE, Players.SEVEN},
            {Players.FOUR, Players.SIX, Players.THREE, Players.EIGHT, Players.ONE, Players.NINE, Players.FIVE, Players.SEVEN, Players.TWO},
            {Players.ONE, Players.TWO, Players.NINE, Players.SEVEN, Players.SIX, Players.FIVE, Players.EIGHT, Players.THREE, Players.FOUR},
            {Players.EIGHT, Players.SEVEN, Players.FIVE, Players.FOUR, Players.THREE, Players.TWO, Players.NINE, Players.SIX, Players.ONE},
            {Players.SIX, Players.FOUR, Players.EIGHT, Players.ONE, Players.TWO, Players.SEVEN, Players.THREE, Players.FIVE, Players.NINE},
            {Players.THREE, Players.FIVE, Players.ONE, Players.NINE, Players.EIGHT, Players.FOUR, Players.SEVEN, Players.TWO, Players.SIX},
            {Players.SEVEN, Players.NINE, Players.TWO, Players.THREE, Players.FIVE, Players.SIX, Players.ONE, Players.FOUR, Players.EIGHT}
    };
    private Players[][] h4_solution = {
            {Players.NINE, Players.SEVEN, Players.FIVE, Players.TWO, Players.THREE, Players.ONE, Players.SIX, Players.FOUR, Players.EIGHT},
            {Players.FOUR, Players.ONE, Players.THREE, Players.NINE, Players.SIX, Players.EIGHT, Players.SEVEN, Players.FIVE, Players.TWO},
            {Players.TWO, Players.EIGHT, Players.SIX, Players.SEVEN, Players.FIVE, Players.FOUR, Players.NINE, Players.THREE, Players.ONE},
            {Players.SEVEN, Players.FIVE, Players.ONE, Players.SIX, Players.EIGHT, Players.TWO, Players.FOUR, Players.NINE, Players.THREE},
            {Players.EIGHT, Players.FOUR, Players.NINE, Players.THREE, Players.ONE, Players.FIVE, Players.TWO, Players.SEVEN, Players.SIX},
            {Players.SIX, Players.THREE, Players.TWO, Players.FOUR, Players.SEVEN, Players.NINE, Players.ONE, Players.EIGHT, Players.FIVE},
            {Players.FIVE, Players.TWO, Players.SEVEN, Players.EIGHT, Players.NINE, Players.SIX, Players.THREE, Players.ONE, Players.FOUR},
            {Players.ONE, Players.NINE, Players.FOUR, Players.FIVE, Players.TWO, Players.THREE, Players.EIGHT, Players.SIX, Players.SEVEN},
            {Players.THREE, Players.SIX, Players.EIGHT, Players.ONE, Players.FOUR, Players.SEVEN, Players.FIVE, Players.TWO, Players.NINE}
    };
    private Players[][] vh1_solution = {
            {Players.NINE, Players.SIX, Players.TWO, Players.SEVEN, Players.FOUR, Players.FIVE, Players.ONE, Players.THREE, Players.EIGHT},
            {Players.FIVE, Players.FOUR, Players.ONE, Players.THREE, Players.EIGHT, Players.NINE, Players.TWO, Players.SEVEN, Players.SIX},
            {Players.SEVEN, Players.THREE, Players.EIGHT, Players.TWO, Players.SIX, Players.ONE, Players.FIVE, Players.FOUR, Players.NINE},
            {Players.ONE, Players.TWO, Players.SIX, Players.EIGHT, Players.SEVEN, Players.FOUR, Players.NINE, Players.FIVE, Players.THREE},
            {Players.FOUR, Players.NINE, Players.SEVEN, Players.SIX, Players.FIVE, Players.THREE, Players.EIGHT, Players.ONE, Players.TWO},
            {Players.THREE, Players.EIGHT, Players.FIVE, Players.NINE, Players.ONE, Players.TWO, Players.SEVEN, Players.SIX, Players.FOUR},
            {Players.EIGHT, Players.FIVE, Players.THREE, Players.ONE, Players.NINE, Players.SIX, Players.FOUR, Players.TWO, Players.SEVEN},
            {Players.TWO, Players.SEVEN, Players.FOUR, Players.FIVE, Players.THREE, Players.EIGHT, Players.SIX, Players.NINE, Players.ONE},
            {Players.SIX, Players.ONE, Players.NINE, Players.FOUR, Players.TWO, Players.SEVEN, Players.THREE, Players.EIGHT, Players.FIVE}
    };
    private Players[][] vh2_solution = {
            {Players.ONE, Players.THREE, Players.NINE, Players.TWO, Players.SEVEN, Players.SIX, Players.FOUR, Players.FIVE, Players.EIGHT},
            {Players.TWO, Players.FIVE, Players.FOUR, Players.ONE, Players.THREE, Players.EIGHT, Players.NINE, Players.SIX, Players.SEVEN},
            {Players.SIX, Players.EIGHT, Players.SEVEN, Players.FOUR, Players.FIVE, Players.NINE, Players.TWO, Players.ONE, Players.THREE},
            {Players.FOUR, Players.ONE, Players.THREE, Players.NINE, Players.EIGHT, Players.TWO, Players.SIX, Players.SEVEN, Players.FIVE},
            {Players.SEVEN, Players.NINE, Players.FIVE, Players.THREE, Players.SIX, Players.ONE, Players.EIGHT, Players.FOUR, Players.TWO},
            {Players.EIGHT, Players.TWO, Players.SIX, Players.FIVE, Players.FOUR, Players.SEVEN, Players.THREE, Players.NINE, Players.ONE},
            {Players.FIVE, Players.SIX, Players.ONE, Players.EIGHT, Players.TWO, Players.FOUR, Players.SEVEN, Players.THREE, Players.NINE},
            {Players.THREE, Players.SEVEN, Players.EIGHT, Players.SIX, Players.NINE, Players.FIVE, Players.ONE, Players.TWO, Players.FOUR},
            {Players.NINE, Players.FOUR, Players.TWO, Players.SEVEN, Players.ONE, Players.THREE, Players.FIVE, Players.EIGHT, Players.SIX}
    };
    private Players[][] vh3_solution = {
            {Players.NINE, Players.SIX, Players.EIGHT, Players.FIVE, Players.THREE, Players.ONE, Players.FOUR, Players.SEVEN, Players.TWO},
            {Players.FIVE, Players.FOUR, Players.SEVEN, Players.EIGHT, Players.TWO, Players.SIX, Players.ONE, Players.THREE, Players.NINE},
            {Players.THREE, Players.TWO, Players.ONE, Players.NINE, Players.SEVEN, Players.FOUR, Players.SIX, Players.FIVE, Players.EIGHT},
            {Players.ONE, Players.NINE, Players.SIX, Players.FOUR, Players.EIGHT, Players.SEVEN, Players.FIVE, Players.TWO, Players.THREE},
            {Players.TWO, Players.SEVEN, Players.THREE, Players.ONE, Players.NINE, Players.FIVE, Players.EIGHT, Players.SIX, Players.FOUR},
            {Players.EIGHT, Players.FIVE, Players.FOUR, Players.TWO, Players.SIX, Players.THREE, Players.SEVEN, Players.NINE, Players.ONE},
            {Players.SIX, Players.EIGHT, Players.FIVE, Players.THREE, Players.FOUR, Players.NINE, Players.TWO, Players.ONE, Players.SEVEN},
            {Players.SEVEN, Players.THREE, Players.TWO, Players.SIX, Players.ONE, Players.EIGHT, Players.NINE, Players.FOUR, Players.FIVE},
            {Players.FOUR, Players.ONE, Players.NINE, Players.SEVEN, Players.FIVE, Players.TWO, Players.THREE, Players.EIGHT, Players.SIX}
    };
    private Players[][] vh4_solution = {
            {Players.FOUR, Players.SIX, Players.EIGHT, Players.NINE, Players.SEVEN, Players.TWO, Players.THREE, Players.FIVE, Players.ONE},
            {Players.NINE, Players.ONE, Players.FIVE, Players.THREE, Players.SIX, Players.EIGHT, Players.FOUR, Players.TWO, Players.SEVEN},
            {Players.SEVEN, Players.TWO, Players.THREE, Players.FOUR, Players.ONE, Players.FIVE, Players.NINE, Players.EIGHT, Players.SIX},
            {Players.ONE, Players.FOUR, Players.SEVEN, Players.SIX, Players.TWO, Players.NINE, Players.FIVE, Players.THREE, Players.EIGHT},
            {Players.TWO, Players.THREE, Players.SIX, Players.FIVE, Players.EIGHT, Players.ONE, Players.SEVEN, Players.NINE, Players.FOUR},
            {Players.EIGHT, Players.FIVE, Players.NINE, Players.SEVEN, Players.THREE, Players.FOUR, Players.ONE, Players.SIX, Players.TWO},
            {Players.SIX, Players.EIGHT, Players.FOUR, Players.ONE, Players.NINE, Players.THREE, Players.TWO, Players.SEVEN, Players.FIVE},
            {Players.THREE, Players.SEVEN, Players.ONE, Players.TWO, Players.FIVE, Players.SIX, Players.EIGHT, Players.FOUR, Players.NINE},
            {Players.FIVE, Players.NINE, Players.TWO, Players.EIGHT, Players.FOUR, Players.SEVEN, Players.SIX, Players.ONE, Players.THREE}
    };

    private Players[][] e1_puzzle = {
            {Players.EMPTY, Players.NINE, Players.SIX, Players.EMPTY, Players.FOUR, Players.EMPTY, Players.EMPTY, Players.THREE, Players.EMPTY},
            {Players.EMPTY, Players.FIVE, Players.SEVEN, Players.EIGHT, Players.TWO, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.ONE, Players.EMPTY, Players.EMPTY, Players.NINE, Players.EMPTY, Players.EMPTY, Players.FIVE, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.NINE, Players.EMPTY, Players.ONE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EIGHT},
            {Players.FIVE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.TWO},
            {Players.FOUR, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.NINE, Players.EMPTY, Players.SIX, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.FOUR, Players.EMPTY, Players.EMPTY, Players.THREE, Players.EMPTY, Players.EMPTY, Players.ONE},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.SEVEN, Players.NINE, Players.TWO, Players.SIX, Players.EMPTY},
            {Players.EMPTY, Players.TWO, Players.EMPTY, Players.EMPTY, Players.FIVE, Players.EMPTY, Players.NINE, Players.EIGHT, Players.EMPTY}
    };
    private Players[][] e2_puzzle = {
            {Players.EMPTY, Players.EMPTY, Players.SEVEN, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.NINE, Players.EMPTY, Players.EIGHT},
            {Players.EMPTY, Players.THREE, Players.EMPTY, Players.ONE, Players.SEVEN, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.FOUR},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.SIX, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.SIX, Players.NINE, Players.EIGHT, Players.SEVEN, Players.FOUR, Players.EMPTY, Players.THREE, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.THREE, Players.EMPTY, Players.ONE, Players.EMPTY, Players.FOUR, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.ONE, Players.EMPTY, Players.THREE, Players.NINE, Players.SEVEN, Players.SIX, Players.TWO},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.FOUR, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.NINE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.FIVE, Players.ONE, Players.EMPTY, Players.FOUR, Players.EMPTY},
            {Players.FOUR, Players.EMPTY, Players.FIVE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.ONE, Players.EMPTY, Players.EMPTY}
    };
    private Players[][] e3_puzzle = {
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.NINE, Players.EMPTY, Players.EMPTY, Players.SIX},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.THREE, Players.EIGHT, Players.FIVE, Players.ONE},
            {Players.EMPTY, Players.SIX, Players.TWO, Players.EMPTY, Players.ONE, Players.FIVE, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.SEVEN, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.SIX, Players.EMPTY},
            {Players.EMPTY, Players.TWO, Players.ONE, Players.NINE, Players.SEVEN, Players.SIX, Players.THREE, Players.EIGHT, Players.EMPTY},
            {Players.EMPTY, Players.THREE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.ONE, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.FOUR, Players.FIVE, Players.EMPTY, Players.NINE, Players.SEVEN, Players.EMPTY},
            {Players.TWO, Players.FIVE, Players.EIGHT, Players.SIX, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.FOUR, Players.EMPTY, Players.EMPTY, Players.THREE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY}
    };
    private Players[][] e4_puzzle = {
            {Players.TWO, Players.NINE, Players.EMPTY, Players.EMPTY, Players.SEVEN, Players.FOUR, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.ONE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.FOUR, Players.EMPTY, Players.EMPTY},
            {Players.SIX, Players.SEVEN, Players.EMPTY, Players.NINE, Players.EMPTY, Players.FIVE, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.TWO, Players.EMPTY, Players.SIX, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.SIX, Players.EMPTY, Players.EIGHT, Players.FOUR, Players.SEVEN, Players.EMPTY, Players.TWO, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.FIVE, Players.EMPTY, Players.ONE, Players.EMPTY, Players.EIGHT, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.SEVEN, Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.NINE, Players.TWO},
            {Players.EMPTY, Players.EMPTY, Players.SIX, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.ONE, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.FOUR, Players.ONE, Players.EMPTY, Players.EMPTY, Players.FIVE, Players.EIGHT}
    };
    private Players[][] m1_puzzle = {
            {Players.ONE, Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.EMPTY, Players.SIX, Players.FOUR, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.SIX, Players.EMPTY, Players.NINE, Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.SEVEN},
            {Players.FIVE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.TWO, Players.SIX, Players.NINE, Players.FIVE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EIGHT, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.FOUR, Players.EMPTY, Players.NINE, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.TWO, Players.SEVEN, Players.NINE, Players.ONE},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.FIVE},
            {Players.SIX, Players.EMPTY, Players.FOUR, Players.EMPTY, Players.SEVEN, Players.EMPTY, Players.TWO, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.ONE, Players.TWO, Players.EMPTY, Players.EMPTY, Players.NINE, Players.EMPTY, Players.THREE}
    };
    private Players[][] m2_puzzle = {
            {Players.FOUR, Players.EMPTY, Players.SIX, Players.EMPTY, Players.TWO, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.FOUR, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.NINE, Players.THREE},
            {Players.THREE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EIGHT, Players.FIVE, Players.EMPTY, Players.EMPTY, Players.TWO},
            {Players.SEVEN, Players.EMPTY, Players.NINE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EIGHT},
            {Players.EMPTY, Players.FIVE, Players.EMPTY, Players.EMPTY, Players.SEVEN, Players.EMPTY, Players.EMPTY, Players.FOUR, Players.EMPTY},
            {Players.SIX, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.SEVEN, Players.EMPTY, Players.ONE},
            {Players.NINE, Players.EMPTY, Players.EMPTY, Players.TWO, Players.FOUR, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.FIVE},
            {Players.TWO, Players.SIX, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.SEVEN, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.THREE, Players.EMPTY, Players.ONE, Players.EMPTY, Players.NINE}
    };
    private Players[][] m3_puzzle = {
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.TWO, Players.FOUR, Players.EMPTY, Players.SIX, Players.EMPTY, Players.EMPTY},
            {Players.NINE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.THREE},
            {Players.ONE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.THREE, Players.EMPTY, Players.FOUR, Players.FIVE},
            {Players.FIVE, Players.SIX, Players.EMPTY, Players.EMPTY, Players.SEVEN, Players.EMPTY, Players.ONE, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.FOUR, Players.EIGHT, Players.EMPTY, Players.FIVE, Players.NINE, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.ONE, Players.EMPTY, Players.SIX, Players.EMPTY, Players.EMPTY, Players.FIVE, Players.TWO},
            {Players.SIX, Players.NINE, Players.EMPTY, Players.FIVE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.ONE},
            {Players.FOUR, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.NINE},
            {Players.EMPTY, Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.NINE, Players.SIX, Players.EMPTY, Players.EMPTY, Players.EMPTY}
    };
    private Players[][] m4_puzzle = {
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.SEVEN, Players.EMPTY, Players.NINE, Players.EMPTY, Players.TWO, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.NINE, Players.TWO, Players.ONE, Players.SIX, Players.EMPTY, Players.EMPTY, Players.FIVE},
            {Players.FIVE, Players.EMPTY, Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.FOUR, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.SIX, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.FOUR, Players.EMPTY, Players.EMPTY},
            {Players.THREE, Players.SEVEN, Players.EMPTY, Players.EMPTY, Players.FOUR, Players.EMPTY, Players.EMPTY, Players.SIX, Players.ONE},
            {Players.EMPTY, Players.EMPTY, Players.TWO, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.FIVE, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.NINE, Players.EMPTY, Players.SEVEN, Players.EMPTY, Players.EMPTY, Players.THREE},
            {Players.SEVEN, Players.EMPTY, Players.EMPTY, Players.THREE, Players.EIGHT, Players.FIVE, Players.TWO, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.THREE, Players.EMPTY, Players.FOUR, Players.EMPTY, Players.ONE, Players.EMPTY, Players.EMPTY, Players.EMPTY}
    };
    private Players[][] h1_puzzle = {
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.SIX},
            {Players.FOUR, Players.EMPTY, Players.FIVE, Players.SIX, Players.NINE, Players.EMPTY, Players.EMPTY, Players.ONE, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.NINE, Players.EMPTY, Players.EMPTY, Players.TWO, Players.FOUR, Players.EMPTY, Players.EMPTY},
            {Players.FIVE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.THREE, Players.EMPTY, Players.EIGHT, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.SEVEN, Players.EIGHT, Players.EMPTY, Players.NINE, Players.SIX, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.NINE, Players.EMPTY, Players.TWO, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.THREE},
            {Players.EMPTY, Players.EMPTY, Players.FOUR, Players.SEVEN, Players.EMPTY, Players.EMPTY, Players.ONE, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.SIX, Players.EMPTY, Players.EMPTY, Players.FOUR, Players.ONE, Players.SEVEN, Players.EMPTY, Players.EIGHT},
            {Players.SEVEN, Players.EMPTY, Players.THREE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY}
    };
    private Players[][] h2_puzzle = {
            {Players.EMPTY, Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.EMPTY, Players.SEVEN, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.FIVE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.SEVEN, Players.EMPTY, Players.ONE},
            {Players.NINE, Players.TWO, Players.EMPTY, Players.ONE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.THREE, Players.SIX},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EIGHT, Players.SEVEN, Players.TWO, Players.EMPTY, Players.EMPTY, Players.FIVE},
            {Players.EMPTY, Players.EMPTY, Players.NINE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.THREE, Players.EMPTY, Players.EMPTY},
            {Players.ONE, Players.EMPTY, Players.EMPTY, Players.NINE, Players.FIVE, Players.THREE, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.THREE, Players.SEVEN, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.NINE, Players.EMPTY, Players.FOUR, Players.EIGHT},
            {Players.TWO, Players.EMPTY, Players.SIX, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.NINE},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.SEVEN, Players.EMPTY, Players.EMPTY, Players.TWO, Players.EMPTY, Players.EMPTY}
    };
    private Players[][] h3_puzzle = {
            {Players.EMPTY, Players.EMPTY, Players.FOUR, Players.TWO, Players.EMPTY, Players.EIGHT, Players.SIX, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.NINE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.FIVE},
            {Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.EMPTY, Players.FOUR, Players.EMPTY, Players.EMPTY, Players.ONE, Players.SEVEN},
            {Players.EMPTY, Players.SIX, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.NINE, Players.FIVE, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.NINE, Players.SEVEN, Players.SIX, Players.FIVE, Players.EIGHT, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.FIVE, Players.FOUR, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.SIX, Players.EMPTY},
            {Players.SIX, Players.FOUR, Players.EMPTY, Players.EMPTY, Players.TWO, Players.EMPTY, Players.EMPTY, Players.FIVE, Players.EMPTY},
            {Players.THREE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.TWO, Players.THREE, Players.EMPTY, Players.SIX, Players.ONE, Players.EMPTY, Players.EMPTY}
    };
    private Players[][] h4_puzzle = {
            {Players.NINE, Players.EMPTY, Players.FIVE, Players.EMPTY, Players.EMPTY, Players.ONE, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.FOUR, Players.EMPTY, Players.THREE, Players.NINE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.FIVE, Players.EMPTY},
            {Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.SEVEN, Players.FIVE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.FIVE, Players.ONE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.THREE},
            {Players.EIGHT, Players.FOUR, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.SEVEN, Players.SIX},
            {Players.SIX, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.ONE, Players.EIGHT, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.NINE, Players.SIX, Players.EMPTY, Players.ONE, Players.EMPTY},
            {Players.EMPTY, Players.NINE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.THREE, Players.EIGHT, Players.EMPTY, Players.SEVEN},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.ONE, Players.EMPTY, Players.EMPTY, Players.FIVE, Players.EMPTY, Players.NINE}
    };
    private Players[][] vh1_puzzle = {
            {Players.NINE, Players.SIX, Players.EMPTY, Players.EMPTY, Players.FOUR, Players.EMPTY, Players.ONE, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.THREE, Players.EIGHT, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.SEVEN, Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.SIX, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.NINE},
            {Players.ONE, Players.TWO, Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.EMPTY, Players.NINE, Players.EMPTY, Players.THREE},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.FIVE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.THREE, Players.EMPTY, Players.FIVE, Players.EMPTY, Players.EMPTY, Players.TWO, Players.EMPTY, Players.SIX, Players.FOUR},
            {Players.EIGHT, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.NINE, Players.EMPTY, Players.FOUR, Players.EMPTY, Players.SEVEN},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.THREE, Players.EIGHT, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.NINE, Players.EMPTY, Players.TWO, Players.EMPTY, Players.EMPTY, Players.EIGHT, Players.FIVE}
    };
    private Players[][] vh2_puzzle = {
            {Players.EMPTY, Players.THREE, Players.EMPTY, Players.TWO, Players.EMPTY, Players.EMPTY, Players.FOUR, Players.EMPTY, Players.EMPTY},
            {Players.TWO, Players.FIVE, Players.EMPTY, Players.ONE, Players.EMPTY, Players.EMPTY, Players.NINE, Players.EMPTY, Players.SEVEN},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.NINE, Players.EMPTY, Players.EMPTY, Players.THREE},
            {Players.FOUR, Players.EMPTY, Players.EMPTY, Players.NINE, Players.EMPTY, Players.TWO, Players.SIX, Players.EMPTY, Players.EMPTY},
            {Players.SEVEN, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.TWO},
            {Players.EMPTY, Players.EMPTY, Players.SIX, Players.FIVE, Players.EMPTY, Players.SEVEN, Players.EMPTY, Players.EMPTY, Players.ONE},
            {Players.FIVE, Players.EMPTY, Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.THREE, Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.EMPTY, Players.FIVE, Players.EMPTY, Players.TWO, Players.FOUR},
            {Players.EMPTY, Players.EMPTY, Players.TWO, Players.EMPTY, Players.EMPTY, Players.THREE, Players.EMPTY, Players.EIGHT, Players.EMPTY}
    };
    private Players[][] vh3_puzzle = {
            {Players.NINE, Players.EMPTY, Players.EMPTY, Players.FIVE, Players.THREE, Players.EMPTY, Players.EMPTY, Players.SEVEN, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.TWO, Players.SIX, Players.EMPTY, Players.EMPTY, Players.NINE},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.SIX, Players.FIVE, Players.EMPTY},
            {Players.EMPTY, Players.EMPTY, Players.SIX, Players.EMPTY, Players.EIGHT, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.THREE},
            {Players.TWO, Players.SEVEN, Players.THREE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EIGHT, Players.SIX, Players.FOUR},
            {Players.EIGHT, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.SIX, Players.EMPTY, Players.SEVEN, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.EIGHT, Players.FIVE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.SEVEN, Players.EMPTY, Players.EMPTY, Players.SIX, Players.ONE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.EMPTY, Players.ONE, Players.EMPTY, Players.EMPTY, Players.FIVE, Players.TWO, Players.EMPTY, Players.EMPTY, Players.SIX}
    };
    private Players[][] vh4_puzzle = {
            {Players.EMPTY, Players.SIX, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY},
            {Players.NINE, Players.EMPTY, Players.EMPTY, Players.THREE, Players.SIX, Players.EIGHT, Players.FOUR, Players.EMPTY, Players.EMPTY},
            {Players.SEVEN, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.ONE, Players.EMPTY, Players.NINE, Players.EMPTY, Players.EMPTY},
            {Players.ONE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.NINE, Players.FIVE, Players.EMPTY, Players.EIGHT},
            {Players.EMPTY, Players.THREE, Players.SIX, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.SEVEN, Players.NINE, Players.EMPTY},
            {Players.EIGHT, Players.EMPTY, Players.NINE, Players.SEVEN, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.TWO},
            {Players.EMPTY, Players.EMPTY, Players.FOUR, Players.EMPTY, Players.NINE, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.FIVE},
            {Players.EMPTY, Players.EMPTY, Players.ONE, Players.TWO, Players.FIVE, Players.SIX, Players.EMPTY, Players.EMPTY, Players.NINE},
            {Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.EMPTY, Players.ONE, Players.EMPTY}
    };
    private Players[][] chosen_puzzle;
    private Players[][] chosen_solution;
    private ArrayList<Players[][]> puzzles = new ArrayList<Players[][]>();
    private ArrayList<Players[][]> solutions = new ArrayList<Players[][]>();

    public Puzzles(Level level){
        setLists(level);
        Random rand = new Random();
        int index = rand.nextInt(4);
        this.chosen_puzzle = puzzles.get(index);
        this.chosen_solution = solutions.get(index);
    }

    public Players[][] get_puzzle() {
        return chosen_puzzle;
    }

    public Players[][] get_solution() {
        return chosen_solution;
    }

    private void setLists(Level level){
        switch (level){
            case EASY:
                puzzles.add(e1_puzzle);
                puzzles.add(e2_puzzle);
                puzzles.add(e3_puzzle);
                puzzles.add(e4_puzzle);
                solutions.add(e1_solution);
                solutions.add(e2_solution);
                solutions.add(e3_solution);
                solutions.add(e4_solution);
                break;
            case MEDIUM:
                puzzles.add(m1_puzzle);
                puzzles.add(m2_puzzle);
                puzzles.add(m3_puzzle);
                puzzles.add(m4_puzzle);
                solutions.add(m1_solution);
                solutions.add(m2_solution);
                solutions.add(m3_solution);
                solutions.add(m4_solution);
                break;
            case HARD:
                puzzles.add(h1_puzzle);
                puzzles.add(h2_puzzle);
                puzzles.add(h3_puzzle);
                puzzles.add(h4_puzzle);
                solutions.add(h1_solution);
                solutions.add(h2_solution);
                solutions.add(h3_solution);
                solutions.add(h4_solution);
                break;
            case VERY_HARD:
                puzzles.add(vh1_puzzle);
                puzzles.add(vh2_puzzle);
                puzzles.add(vh3_puzzle);
                puzzles.add(vh4_puzzle);
                solutions.add(vh1_solution);
                solutions.add(vh2_solution);
                solutions.add(vh3_solution);
                solutions.add(vh4_solution);
                break;
            default:
                puzzles.add(e1_puzzle);
                puzzles.add(m2_puzzle);
                puzzles.add(h3_puzzle);
                puzzles.add(vh4_puzzle);
                solutions.add(e1_solution);
                solutions.add(m2_solution);
                solutions.add(h3_solution);
                solutions.add(vh4_solution);
                break;
        }
    }
}
