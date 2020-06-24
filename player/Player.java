package tictactoe.player;

import tictactoe.Position;

public abstract class Player {

    protected Position choice;

    public Player(Position position) {
        choice = position;
    }

    public abstract Position[][] nextMove(Position[][] matrix);
}