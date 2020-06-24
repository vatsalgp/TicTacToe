package tictactoe.player;

import tictactoe.Position;

public class PlayerFactory {

    Position choice;

    public PlayerFactory(Position position) {
        choice = position;
    }

    public Player newPlayer(String string) {
        switch (string.toLowerCase()) {
            case "user":
                return new User(choice);
            default:
                return new AI(choice);
        }
    }
}