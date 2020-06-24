package tictactoe;

public enum Position {
    Empty(" "), X("X"), O("O");

    private String value;

    Position(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Position Flip(Position value) {
        switch (value) {
            case X:
                return O;
            case O:
                return X;
            default:
                return Empty;
        }
    }

    public static Position setValue(char val) {
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