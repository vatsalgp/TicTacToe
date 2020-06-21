package tictactoe;

import java.util.Scanner;

public class Main {
    private static Position[][] matrix = new Position[3][3];
    private static Position move = Position.X;
    private static GameState state = GameState.OnGoing;
    final private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initMatrix();
        while (!hasGameEnded()) {
            printMatrix();
            updateMatrix();
            updateState();
        }
        printMatrix();
        System.out.println(state.getValue());
    }

    private static void initMatrix() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                matrix[i][j] = Position.Empty;
    }

    private static boolean hasGameEnded() {
        return state == GameState.X || state == GameState.O || state == GameState.Draw;
    }

    private static void updateMatrix() {
        if (move == Position.X)
            System.out.println("X's Turn");
        else
            System.out.println("O's Turn");
        while (true) {
            System.out.print("Enter the row number(1, 2, 3): ");
            int x = scanner.nextInt() - 1;
            System.out.print("Enter the col number(1, 2, 3): ");
            int y = scanner.nextInt() - 1;
            if (!(x >= 0 && x <= 2 && y >= 0 && y <= 2))
                System.out.println("Invalid cell");
            else if (matrix[x][y] != Position.Empty)
                System.out.println("This cell is occupied! Choose another one!");
            else {
                matrix[x][y] = move;
                move = move == Position.X ? Position.O : Position.X;
                return;
            }
        }
    }

    private static void printMatrix() {
        System.out.println("---------");
        for (Position[] row : matrix) {
            System.out.print("| ");
            for (Position pos : row)
                System.out.print(pos.getValue() + " ");
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static void updateState() {
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
