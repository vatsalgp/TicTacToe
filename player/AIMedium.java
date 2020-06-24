package tictactoe.player;

import tictactoe.Position;

public class AIMedium extends AI {

    public AIMedium(Position position) {
        super(position);
    }

    private boolean checkHorizontal(Position[][] matrix) {
        for (int i = 0; i < 3; i++) {
            int x = 0;
            int o = 0;
            int e = 0;
            for (int j = 0; j < 3; j++) {
                switch (matrix[i][j]) {
                    case X:
                        x++;
                        break;
                    case O:
                        o++;
                        break;
                    default:
                        e++;
                }
            }
            if (e == 1 && (x == 2 || o == 2))
                return true;
        }
        return false;
    }

    private Position[][] alterHorizontal(Position[][] matrix) {
        for (int i = 0; i < 3; i++) {
            int x = 0;
            int o = 0;
            int e = 0;
            for (int j = 0; j < 3; j++) {
                switch (matrix[i][j]) {
                    case X:
                        x++;
                        break;
                    case O:
                        o++;
                        break;
                    default:
                        e++;
                }
            }
            if (e == 1 && (x == 2 || o == 2)) {
                for (int j = 0; j < 3; j++) {
                    if (matrix[i][j] == Position.Empty) {
                        matrix[i][j] = choice;
                        return matrix;
                    }
                }
            }
        }
        return matrix;
    }

    private boolean checkVertical(Position[][] matrix) {
        for (int i = 0; i < 3; i++) {
            int x = 0;
            int o = 0;
            int e = 0;
            for (int j = 0; j < 3; j++) {
                switch (matrix[j][i]) {
                    case X:
                        x++;
                        break;
                    case O:
                        o++;
                        break;
                    default:
                        e++;
                }
            }
            if (e == 1 && (x == 2 || o == 2))
                return true;
        }
        return false;
    }

    private Position[][] alterVertical(Position[][] matrix) {
        for (int i = 0; i < 3; i++) {
            int x = 0;
            int o = 0;
            int e = 0;
            for (int j = 0; j < 3; j++) {
                switch (matrix[j][i]) {
                    case X:
                        x++;
                        break;
                    case O:
                        o++;
                        break;
                    default:
                        e++;
                }
            }
            if (e == 1 && (x == 2 || o == 2)) {
                for (int j = 0; j < 3; j++) {
                    if (matrix[j][i] == Position.Empty) {
                        matrix[j][i] = choice;
                        return matrix;
                    }
                }
            }
        }
        return matrix;
    }

    private boolean checkDiagPrim(Position[][] matrix) {
        int x = 0;
        int o = 0;
        int e = 0;
        for (int i = 0; i < 3; i++) {
            switch (matrix[i][i]) {
                case X:
                    x++;
                    break;
                case O:
                    o++;
                    break;
                default:
                    e++;
            }
        }
        return e == 1 && (x == 2 || o == 2);
    }

    private Position[][] alterDiagPrim(Position[][] matrix) {
        for (int i = 0; i < 3; i++) {
            if (matrix[i][i] == Position.Empty) {
                matrix[i][i] = choice;
                return matrix;
            }
        }
        return matrix;
    }

    private boolean checkDiagSec(Position[][] matrix) {
        int x = 0;
        int o = 0;
        int e = 0;
        for (int i = 0; i < 3; i++) {
            switch (matrix[i][2 - i]) {
                case X:
                    x++;
                    break;
                case O:
                    o++;
                    break;
                default:
                    e++;
            }
        }
        return e == 1 && (x == 2 || o == 2);
    }

    private Position[][] alterDiagSec(Position[][] matrix) {
        for (int i = 0; i < 3; i++) {
            if (matrix[i][2 - i] == Position.Empty) {
                matrix[i][2 - i] = choice;
                return matrix;
            }
        }
        return matrix;
    }

    @Override
    public Position[][] nextMove(Position[][] matrix) {
        System.out.println("Making move level \"medium\"");
        if (checkHorizontal(matrix))
            return alterHorizontal(matrix);
        else if (checkVertical(matrix))
            return alterVertical(matrix);
        else if (checkDiagPrim(matrix))
            return alterDiagPrim(matrix);
        else if (checkDiagSec(matrix))
            return alterDiagSec(matrix);
        else
            return makeRandomMove(matrix);
    }
}