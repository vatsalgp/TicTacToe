package tictactoe;

enum GameState {
    X("X wins"), O("O wins"), Draw("Draw"), OnGoing("Game not finished"), Impossible("Impossible");

    private String value;

    GameState(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }
}
