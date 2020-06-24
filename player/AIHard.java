package tictactoe.player;

import tictactoe.Position;
import tictactoe.GameCheck;

public class AIHard extends AI {

    public AIHard(Position position) {
        super(position);
    }

    @Override
    public Position[][] nextMove(Position[][] matrix) {
        System.out.println("Making move level \"hard\"");
        Move move = minimax(matrix, choice);
        matrix[move.x][move.y] = choice;
        return matrix;
    }

    private Move minimax(Position[][] matrix, Position player) {
        GameCheck game = new GameCheck(matrix);
        if (game.checkForWin(player))
            return new Move(player);
        else if (game.checkForWin(Position.Flip(player)))
            return new Move(Position.Flip(player));
        else if (!game.hasEmptyCells())
            return new Move(Position.Empty);
        Move[] moves = new Move[game.count(Position.Empty)];
        int l = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == Position.Empty) {
                    matrix[i][j] = player;
                    Move move = minimax(matrix, Position.Flip(player));
                    move.x = i;
                    move.y = j;
                    matrix[i][j] = Position.Empty;
                    moves[l++] = move;
                }
            }
        }
        if (player == Position.O) {
            Move bestMove = new Move();
            bestMove.countX = Integer.MAX_VALUE;
            for (Move move : moves)
                if (move.countX < bestMove.countX)
                    bestMove = move;
            return bestMove;
        } else {
            Move bestMove = new Move();
            bestMove.countX = Integer.MIN_VALUE;
            for (Move move : moves)
                if (move.countX > bestMove.countX)
                    bestMove = move;
            return bestMove;
        }
    }
}