package tictactoe;

import java.util.Scanner;
import tictactoe.player.*;

public class TicTacToe {
    private static Position[][] matrix = new Position[3][3];
    private static Position move = Position.X;
    private static GameState state = GameState.OnGoing;
    private static Player X;
    private static Player O;
    final private static Scanner scanner = new Scanner(System.in);

    public static void getInput() {
        System.out.print("Input command: ");
        String mode = scanner.next();
        if (mode.equals("exit"))
            System.exit(0);
        PlayerFactory xFactory = new PlayerFactory(Position.X);
        PlayerFactory yFactory = new PlayerFactory(Position.O);
        X = xFactory.newPlayer(scanner.next());
        O = yFactory.newPlayer(scanner.next());
    }

    static void printState() {
        System.out.println(state.getValue());
    }

    static void initMatrix() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                matrix[i][j] = Position.Empty;
    }

    static boolean hasGameEnded() {
        return state == GameState.X || state == GameState.O || state == GameState.Draw;
    }

    static void updateMatrix() {
        if (move == Position.X)
            matrix = X.nextMove(matrix);
        else
            matrix = O.nextMove(matrix);
        move = Position.Flip(move);
    }

    static void printMatrix() {
        System.out.println("---------");
        for (Position[] row : matrix) {
            System.out.print("| ");
            for (Position pos : row)
                System.out.print(pos.getValue() + " ");
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static void updateState() {
        if (checkForWinForX() && checkForWinForO() || Math.abs(countX() - countO()) > 1)
            state = GameState.Impossible;
        else if (checkForWinForX())
            state = GameState.X;
        else if (checkForWinForO())
            state = GameState.O;
        else if (hasEmptyCells())
            state = GameState.OnGoing;
        else
            state = GameState.Draw;
    }

    private static boolean checkForWin(Position pos) {
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

    private static boolean checkForWinForX() {
        return checkForWin(Position.X);
    }

    private static boolean checkForWinForO() {
        return checkForWin(Position.O);
    }

    private static boolean hasEmptyCells() {
        for (Position[] row : matrix)
            for (Position pos : row)
                if (pos == Position.Empty)
                    return true;
        return false;
    }

    private static int count(Position givenPos) {
        int out = 0;
        for (Position[] row : matrix)
            for (Position pos : row)
                if (pos == givenPos)
                    out++;
        return out;
    }

    private static int countX() {
        return count(Position.X);
    }

    private static int countO() {
        return count(Position.O);
    }
}