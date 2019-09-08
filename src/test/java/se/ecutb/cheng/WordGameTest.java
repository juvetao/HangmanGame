package se.ecutb.cheng;

import org.junit.Assert;
import org.junit.Test;

public class WordGameTest {

    private static WordGame testObject;

    @Test
    public void test_Object_created_successfully(){
        testObject = new WordGame("KING");
        Assert.assertNull(testObject.getDisplays());
        Assert.assertEquals(0, testObject.getIncorrectGuesses());
        Assert.assertEquals(8,testObject.getMaxIncorrectGuesses());
    }

    @Test
    public void test_guess_letter(){
        testObject = new WordGame("KING");
        Assert.assertFalse(testObject.guess('O'));
        Assert.assertFalse(testObject.guess('K'));//Until all the letters are correct
    }

    @Test
    public void test_guess_word(){
        testObject = new WordGame("KING");
        Assert.assertTrue(testObject.guess("KING"));
        Assert.assertFalse(testObject.guess("OMG"));
    }

    @Test
    public void test_updatePositionForCorrectLetter(){
        testObject = new WordGame("OTTO");
        testObject.startNewGame();
        String string1 = testObject.updatePositionForCorrectLetter('O');
        Assert.assertEquals("O _ _ O",string1);
        String string2 = testObject.updatePositionForCorrectLetter('T');
        Assert.assertEquals("O T T O",string2);
    }
}