package se.ecutb.cheng;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args ) throws IOException {
        boolean keepAlive = true;

        do{
            WordGame game = new WordGame(SecretWordsPool.pickUpSecretWord());
            PlayerInterface session = new PlayerInterface(game);
            session.run();

            System.out.println("Do you want to quit? (y/n)");
            switch (PlayerInput.getString().trim().toLowerCase()){
                case "y":
                    keepAlive = false;
                    System.out.println("Bye");
                    break;
            }
        }while(keepAlive);
    }
}
