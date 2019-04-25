package strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * RemoveWhiteSpaces
 * Learning
 *
 * Method to remove white spaces
 *
 * @author WissenSolutions.
 */
public class RemoveWhiteSpaces {
    @Test
    public void testRemoveWhiteSpaces() {
        String input = " This is a sentence";
        Assert.assertEquals("Thisisasentence", removeWhiteSpace(input));
    }

    private String removeWhiteSpace(String sentence){
        char[] chars = sentence.toCharArray();
        StringBuilder builder = new StringBuilder();

        for(Character character : chars){
            if(! (character.equals(" ")|| character.equals(' ')|| character.equals('\t') )){
                builder.append(character);
            }
        }
        return builder.toString();
    }
}
