package tictactoe;

import java.util.Scanner;

public class TicTacToe {
    private static Position[][] matrix = new Position[3][3];
    private static Position move = Position.X;
    private static GameState state = GameState.OnGoing;
    final private static Scanner scanner = new Scanner(System.in);

    static void printState() {
        System.out.println(state.getValue());
    }

    static void initMatrix() {
//        System.out.print("Enter cells: ");
//        String string = scanner.nextLine();
        int l = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
//                matrix[i][j] = Position.setValue(string.charAt(l++));
                  matrix[i][j] = Position.Empty;
//        if (countX() > countO())
//            move = Position.O;
    }

    static boolean hasGameEnded() {
        return state == GameState.X || state == GameState.O || state == GameState.Draw;
    }

    static void updateMatrix() {
        if (move == Position.X) {
            while (true) {
                System.out.print("Enter the coordinates:");
                String first = scanner.next();
                if (!isNumber(first)) {
                    System.out.println("You should enter numbers!");
                    continue;
                }
                String second = scanner.next();
                if (!isNumber(second)) {
                    System.out.println("You should enter numbers!");
                    continue;
                }
                int y = Integer.parseInt(first) - 1;
                int x = Integer.parseInt(second) - 1;
                if (x == 0)
                    x = 2;
                else if (x == 2)
                    x = 0;
                if (!(x >= 0 && x <= 2 && y >= 0 && y <= 2))
                    System.out.println("Coordinates should be from 1 to 3!");
                else if (matrix[x][y] != Position.Empty)
                    System.out.println("This cell is occupied! Choose another one!");
                else {
                    matrix[x][y] = move;
                    move = move == Position.X ? Position.O : Position.X;
                    return;
                }
            }
        } else {
            System.out.println("Making move level \"easy\"");
            makeRandomMove();
            move = move == Position.X ? Position.O : Position.X;
        }
    }

    private static void makeRandomMove() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == Position.Empty) {
                    matrix[i][j] = Position.O;
                    return;
                }
            }
        }
    }

    private static boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (Exception e) {
            return false;
        }
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