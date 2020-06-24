package tictactoe.player.ai;

import tictactoe.game.Position;
import tictactoe.player.Player;

public abstract class AI extends Player {

    public AI(Position position) {
        super(position);
    }

    protected Position[][] makeRandomMove(Position[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == Position.Empty) {
                    matrix[i][j] = choice;
                    return matrix;
                }
            }
        }
        return matrix;
    }
}