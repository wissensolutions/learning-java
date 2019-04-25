package strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * ReverseCharacters
 * Learning
 *
 * Given a string, reverse it's words and characters
 *
 * @author WissenSolutions.
 */
public class ReverseCharacters {
    @Test
    public void testReverseCharacters() {
        String sentence = "This is a sentence";
        Assert.assertEquals("ecnetnes a si sihT", reverseCharacters(sentence));
    }

    private String reverseCharacters(String sentence ){
        char[] chars = sentence.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=chars.length-1;i >= 0; i--){
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
