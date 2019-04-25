package strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * LengthOfLastWord
 * Learning
 *
 * @author WissenSolutions.
 */
public class LengthOfLastWord {
    @Test
    public void testLengthOfLastWord() {
        String sentence = " This is a sentence";
        Assert.assertEquals(8, lengthOfLastWordWithSplit(sentence));
        Assert.assertEquals(8, lengthOfLastWord(sentence));
    }

    private int lengthOfLastWordWithSplit(String sentence){
        String[] array = sentence.split(" ");
        return array[array.length-1].length();
    }

    private int lengthOfLastWord(String sentence){
        char[] array = sentence.toCharArray();
        int count = 0;
        int length = array.length;
        for(int i=0; i<array.length; i++){
            if(array[i] == ' ' || array[i] == '\t'){
                count = 0;
            } else {
                count++;
            }
        }

        return count;


    }
}
