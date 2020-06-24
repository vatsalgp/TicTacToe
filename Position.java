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

    static Position setValue(char val) {
        switch (val) {
            case 'X':
                return X;
            case 'O':
                return O;
            default:
                return Empty;
        }
    }
}