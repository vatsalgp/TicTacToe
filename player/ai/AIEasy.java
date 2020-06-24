package tictactoe.player.ai;

import tictactoe.game.Position;

public class AIEasy extends AI {

    public AIEasy(Position position) {
        super(position);
    }

    @Override
    public Position[][] nextMove(Position[][] matrix) {
        System.out.println("Making move level \"easy\"");
        return makeRandomMove(matrix);
    }
}