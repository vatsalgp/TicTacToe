package tictactoe.player.user;

import java.util.Scanner;
import tictactoe.game.Position;
import tictactoe.player.Player;

public class User extends Player {
    public User(Position position) {
        super(position);
    }

    final private static Scanner scanner = new Scanner(System.in);

    @Override
    public Position[][] nextMove(Position[][] matrix) {
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
                matrix[x][y] = choice;
                return matrix;
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
}