/*
    Rows and Cols start from 1.
    X starts first.
    X -> 1
    O -> -1
*/

import java.util.Scanner;

public class TicTacToe {
    private static int[][] matrix = new int[3][3];
    private static int move = 1;
    private static State state = State.Empty;
    final private static Scanner scanner = new Scanner(System.in);

    private static enum State {
        X("X wins"), O("O wins"), Draw("Draw"), Empty("Game not finished"), Impossible("Impossible");

        String value;

        State(String val) {
            value = val;
        }

        String getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        while (!hasGameEnded()) {
            printMatrix();
            updateMatrix();
            updateState();
        }
        printMatrix();
        System.out.println(state.getValue());
    }

    private static boolean hasGameEnded() {
        return state == State.X || state == State.O || state == State.Draw;
    }

    private static void updateMatrix() {
        while (true) {
            System.out.print("Enter the coordinates: ");
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            if (!(x >= 0 && x <= 2 && y >= 0 && y <= 2))
                System.out.println("Invalid cell");
            else if (matrix[x][y] != 0)
                System.out.println("This cell is occupied! Choose another one!");
            else {
                matrix[x][y] = move;
                move *= -1;
                return;
            }
        }
    }

    private static void printMatrix() {
        System.out.println("---------");
        for (int[] arr : matrix) {
            System.out.print("| ");
            for (int ele : arr) {
                String out = "";
                switch (ele) {
                    case 1:
                        out = "X ";
                        break;
                    case -1:
                        out = "O ";
                        break;
                    default:
                        out = "  ";
                }
                System.out.print(out);
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static void updateState() {
        if (checkForWinForX() && checkForWinForO() || Math.abs(countX() - countO()) > 1)
            state = State.Impossible;
        else if (checkForWinForX())
            state = State.X;
        else if (checkForWinForO())
            state = State.O;
        else if (hasEmptyCells())
            state = State.Empty;
        else
            state = State.Draw;
    }

    private static boolean checkForWin(int c) {
        for (int i = 0; i < 3; i++)
            if (matrix[i][0] == c && matrix[i][1] == c && matrix[i][2] == c)
                return true;
        for (int i = 0; i < 3; i++)
            if (matrix[0][i] == c && matrix[1][i] == c && matrix[2][i] == c)
                return true;
        if (matrix[0][0] == c && matrix[1][1] == c && matrix[2][2] == c)
            return true;
        if (matrix[0][2] == c && matrix[1][1] == c && matrix[2][0] == c)
            return true;
        return false;
    }

    private static boolean checkForWinForX() {
        return checkForWin(1);
    }

    private static boolean checkForWinForO() {
        return checkForWin(-1);
    }

    private static boolean hasEmptyCells() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (matrix[i][j] == 0)
                    return true;
        return false;
    }

    private static int count(int c) {
        int out = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (matrix[i][j] == c)
                    out++;
        return out;
    }

    private static int countX() {
        return count(1);
    }

    private static int countO() {
        return count(-1);
    }
}
