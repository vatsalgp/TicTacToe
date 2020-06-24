package tictactoe.game;

import java.util.Scanner;

import tictactoe.game.status.GameCheck;
import tictactoe.game.status.GameState;
import tictactoe.player.*;
import tictactoe.player.factory.PlayerFactory;

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

    public static void printState() {
        System.out.println(state.getValue());
    }

    public static void initMatrix() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                matrix[i][j] = Position.Empty;
    }

    public static boolean hasGameEnded() {
        return state == GameState.X || state == GameState.O || state == GameState.Draw;
    }

    public static void updateMatrix() {
        if (move == Position.X)
            matrix = X.nextMove(matrix);
        else
            matrix = O.nextMove(matrix);
        move = Position.Flip(move);
    }

    public static void printMatrix() {
        System.out.println("---------");
        for (Position[] row : matrix) {
            System.out.print("| ");
            for (Position pos : row)
                System.out.print(pos.getValue() + " ");
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static void updateState() {
        GameCheck game = new GameCheck(matrix);
        state = game.getState();
    }
}