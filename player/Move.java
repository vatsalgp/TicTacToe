package tictactoe.player;

import tictactoe.game.Position;

public class Move {
    public int x = 0;
    public int y = 0;
    public int countX = 0;

    public Move(int countX) {
        this.countX = countX;
    }

    public Move(Position position) {
        counter(position);
    }

    public int counter(Position position) {
        switch (position) {
            case X:
                return ++countX;
            case O:
                return --countX;
            default:
                return countX;
        }
    }
}