package tictactoe.player.user;

import tictactoe.io.Input;
import tictactoe.game.Position;
import tictactoe.player.Player;

public class User extends Player {
    public User(Position position) {
        super(position);
    }

    @Override
    public Position[][] nextMove(Position[][] matrix) {
        while (true) {
            System.out.print("Enter row(1, 2, 3): ");
            String first = Input.nextLine();
            System.out.print("Enter col(1, 2, 3): ");
            String second = Input.nextLine();
            if (Input.isNumber(first) && Input.isNumber(second)) {
                int x = Integer.parseInt(first) - 1;
                int y = Integer.parseInt(second) - 1;
                if (!(x >= 0 && x <= 2 && y >= 0 && y <= 2))
                    System.out.println("Coordinates should be from 1 to 3!");
                else if (matrix[x][y] != Position.Empty)
                    System.out.println("This cell is occupied! Choose another one!");
                else {
                    matrix[x][y] = choice;
                    return matrix;
                }
            } else
                System.out.println("You should enter numbers!");
        }
    }

}