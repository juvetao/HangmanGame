package se.ecutb.cheng;

import java.util.Scanner;

public class PlayerInput {
    private static Scanner scanner = new Scanner(System.in);

    public static char getChar(){
        String letters = scanner.next().trim().toUpperCase();
        char letter = letters.charAt(0);
        return letter;
        }

    public static String getString(){
        String letters = scanner.next().trim().toUpperCase();
        return letters;
    }

    }


