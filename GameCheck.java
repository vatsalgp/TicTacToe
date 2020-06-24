package tictactoe;

public class GameCheck {
    final private Position[][] matrix;

    public GameCheck(Position[][] matrix) {
        this.matrix = matrix;
    }

    public GameState getState() {
        if (checkForWinForX() && checkForWinForO() || Math.abs(countX() - countO()) > 1)
            return GameState.Impossible;
        else if (checkForWinForX())
            return GameState.X;
        else if (checkForWinForO())
            return GameState.O;
        else if (hasEmptyCells())
            return GameState.OnGoing;
        else
            return GameState.Draw;
    }

    public boolean checkForWin(Position pos) {
        for (int i = 0; i < 3; i++)
            if (matrix[i][0] == pos && matrix[i][1] == pos && matrix[i][2] == pos)
                return true;
        for (int i = 0; i < 3; i++)
            if (matrix[0][i] == pos && matrix[1][i] == pos && matrix[2][i] == pos)
                return true;
        if (matrix[0][0] == pos && matrix[1][1] == pos && matrix[2][2] == pos)
            return true;
        if (matrix[0][2] == pos && matrix[1][1] == pos && matrix[2][0] == pos)
            return true;
        return false;
    }

    public boolean checkForWinForX() {
        return checkForWin(Position.X);
    }

    public boolean checkForWinForO() {
        return checkForWin(Position.O);
    }

    public boolean hasEmptyCells() {
        for (Position[] row : matrix)
            for (Position pos : row)
                if (pos == Position.Empty)
                    return true;
        return false;
    }

    public int count(Position givenPos) {
        int out = 0;
        for (Position[] row : matrix)
            for (Position pos : row)
                if (pos == givenPos)
                    out++;
        return out;
    }

    public int countX() {
        return count(Position.X);
    }

    public int countO() {
        return count(Position.O);
    }
}