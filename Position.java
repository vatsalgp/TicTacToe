package tictactoe;

enum Position {
    Empty(" "), X("X"), O("O");

    private String value;

    Position(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }
}