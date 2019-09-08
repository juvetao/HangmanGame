package se.ecutb.cheng;

import java.util.Scanner;

public class PlayerInterface {
    private WordGame game;
    private boolean correct;

    public PlayerInterface(WordGame game){
        this.game = game;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("The length of the word is: " + game.getDisplays().length);
        game.startNewGame();
        while (!correct & game.getIncorrectGuesses() < game.getMaxIncorrectGuesses() ){
            System.out.println("Incorrect Guess "+game.getIncorrectGuesses() + "/"+game.getMaxIncorrectGuesses());
            System.out.println("Guess a letter or word (l/w)");
            char letterOrWord = scanner.next().trim().toLowerCase().charAt(0);

            switch (letterOrWord){
                case 'l':
                    System.out.println("Please enter a letter");
                    char guessLetter = PlayerInput.getChar();
                    correct = game.guess(guessLetter);
                    break;
                case 'w':
                    System.out.println("Please enter a word");
                    String guessWord = PlayerInput.getString();
                    correct = game.guess(guessWord);
                    break;
            }
        }
    }
}
