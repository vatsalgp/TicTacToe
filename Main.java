package tictactoe;

import tictactoe.game.TicTacToe;

public class Main {
    public static void main(String[] args) {
        TicTacToe.getInput();
        TicTacToe.initMatrix();
        while (!TicTacToe.hasGameEnded()) {
            TicTacToe.printMatrix();
            TicTacToe.updateMatrix();
            TicTacToe.updateState();
        }
        TicTacToe.printMatrix();
        TicTacToe.printState();
    }
}
