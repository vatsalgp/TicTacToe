package tictactoe.io;

import java.util.Scanner;

public class Input {
    final private static Scanner scanner = new Scanner(System.in);

    public static String nextLine() {
        return scanner.nextLine();
    }

    public static boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}