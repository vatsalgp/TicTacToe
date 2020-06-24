package tictactoe.player.factory;

import tictactoe.game.Position;
import tictactoe.player.Player;
import tictactoe.player.ai.*;
import tictactoe.player.user.User;

public class PlayerFactory {

    Position choice;

    public PlayerFactory(Position position) {
        choice = position;
    }

    public Player newPlayer(String string) {
        switch (string.toLowerCase()) {
            case "user":
                return new User(choice);
            case "easy":
                return new AIEasy(choice);
            case "medium":
                return new AIMedium(choice);
            case "hard":
                return new AIHard(choice);
            default:
                return null;
        }
    }
}