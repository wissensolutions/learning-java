package strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * ReverseVowels
 * Learning
 *
 * Reverse vowels in a given string
 *
 * @author WissenSolutions.
 */
public class ReverseVowels {
    @Test
    public void testReverseVowels() {
        String sentence = "hello";
        Assert.assertEquals("olleh", reverseVowels(sentence));
    }

    private String reverseVowels(String sentence){
        Set<Character> set = new HashSet<>();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');

        set.add('A');set.add('E');set.add('I');set.add('O');set.add('U');

        char[] chars = sentence.toCharArray();
        int j=chars.length-1;
        for(int i=0; i < sentence.length() && j>=0; i++){
            if(set.contains(sentence.charAt(i))){
                swap(i, j, chars);
            }

            j--;

        }
        return new String(chars);
    }
    private void swap(int first, int second, char[] chars){

        char temp = chars[first];
        chars[first]= chars[second];
        chars[second] = temp;

    }
}
