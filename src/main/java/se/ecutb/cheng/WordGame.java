package se.ecutb.cheng;

import java.util.ArrayList;

public class WordGame {
    //word players will guess
    private String secretWord;
    //display on the screen
    private char[] displays;
    //pool of incorrect guess letters
    private StringBuilder incorrectLetters = new StringBuilder();
    //Amount of incorrect guesses
    private int incorrectGuesses;
    //Max amount of incorrect guesses
    private int maxIncorrectGuesses;
    //
    private ArrayList<String> finaloutput;


    public WordGame(String secretWord) {
        this.secretWord = secretWord;
        this.displays = new char[secretWord.length()];
//        for (int i = 0; i<secretWord.length();i++){
//            display[i] ='_';
//        }
        //incorrectLetters = null;
        incorrectGuesses = 0;
        maxIncorrectGuesses = 8;
        this.finaloutput = new ArrayList<>();
    }

    public char[] getDisplays() {
        return displays;
    }

    public void setDisplays(char[] displays) {
        this.displays = displays;
    }

    public StringBuilder getIncorrectLetters() {
        return incorrectLetters;
    }

    public int getIncorrectGuesses() {
        return incorrectGuesses;
    }

    public int getMaxIncorrectGuesses() {
        return maxIncorrectGuesses;
    }

    public ArrayList<String> getFinaloutput() {
        return finaloutput;
    }

    public void setFinaloutput(ArrayList<String> finaloutput) {
        this.finaloutput = finaloutput;
    }

    public void startNewGame(){
        for(int i = 0; i < secretWord.length(); i++){
            displays[i] = '_';
        }
    }

    //guess a letter
    public boolean guess(char guessLetter) {
        if (!updatePositionForCorrectLetter(guessLetter).replaceAll(" ", "").equalsIgnoreCase(secretWord)) {
            if (secretWord.contains(String.valueOf(guessLetter))) {
                System.out.println(updatePositionForCorrectLetter(guessLetter));
                return false;
            } else if (!secretWord.contains(String.valueOf(guessLetter))) {
                incorrectGuesses++;
                incorrectLetters.append(guessLetter);
                incorrectLetters.append(" ");
                System.out.println("The pool of incorrect letters or words: \n" + incorrectLetters.toString());
                return false;
            }
        }
        System.out.println(updatePositionForCorrectLetter(guessLetter));
        System.out.println("Correct! The word is: " + updatePositionForCorrectLetter(guessLetter).replaceAll(" ", ""));
        return true;
    }

        //"_" will be replaced with correct letter(s)
        public String updatePositionForCorrectLetter(char guessLetter){
            //String newDisplay = readDisplayArray(getDisplay()).toString();;
            //String result = new String (display);
            char temp = ' ';
            for(int i = 0; i<secretWord.length(); i++){
                //index = secretWord.indexOf(guessLetter,i);
                temp = secretWord.charAt(i);
                if (guessLetter == temp){
                    displays[i] = temp;
                }
                setDisplays(displays);

            }return readDisplayArray(getDisplays()).trim();
        }

    //guess a word
    public boolean guess (String guessWord){
        if(!guessWord.equalsIgnoreCase(secretWord)){
            incorrectGuesses++;
            incorrectLetters.append(guessWord);
            incorrectLetters.append(" ");
            System.out.println("The pool of incorrect letters or words: \n"+ incorrectLetters.toString());
            return false;
        }else {
            displays = guessWord.toCharArray();
            System.out.println("Correct! The word is: "+guessWord);
            return true;
        }
    }

    public String readDisplayArray (char[] displays){
        StringBuilder printResult = new StringBuilder();
        for(int i = 0; i< displays.length; i++){
            printResult.append(displays[i]);
            printResult.append(' ');
        }
        return printResult.toString();
    }

}