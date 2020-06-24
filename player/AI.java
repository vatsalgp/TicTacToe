package tictactoe.player;

import tictactoe.Position;

public class AI extends Player {

    public AI(Position position) {
        super(position);
    }

    @Override
    public Position[][] nextMove(Position[][] matrix) {
        System.out.println("Making move level \"easy\"");
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