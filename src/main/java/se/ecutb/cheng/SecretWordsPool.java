package se.ecutb.cheng;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class SecretWordsPool {
    public static String pickUpSecretWord() throws IOException {
        Random random = new Random();
        String[] secretWordPool = new String[]{"OTTO", "king", "Game", "Final", "Juventus"};
        String secretWord = secretWordPool[random.nextInt(secretWordPool.length)].toUpperCase();

//        String [] secretWords = new String[0];
//        BufferedReader reader = new BufferedReader(new FileReader("secretwords.csv"));
//        String line;
//        while((line = reader.readLine())!=null){
//           secretWords = line.split(", ");
//        }
//        String secretWord = secretWords[random.nextInt(secretWords.length)].toUpperCase();
//
//        System.out.println(secretWord);

        return secretWord;
    }
}
