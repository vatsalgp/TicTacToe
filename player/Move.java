package tictactoe.player;

import tictactoe.Position;

class Move {
    int x = 0;
    int y = 0;
    int countX = 0;

    Move() {
    }

    Move(Position position) {
        counter(position);
    }

    int counter(Position position) {
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