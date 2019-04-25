package strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * LengthOfLongestPalindromeSequence
 * Learning
 *
 * @author WissenSolutions.
 */
public class LengthOfLongestPalindromeSequence {
    @Test
    public void testLengthOfLongestPalindromeSequence() {
        Assert.assertEquals(4, longestPalindromeStringLength("bbbab") );
        Assert.assertEquals(2, longestPalindromeStringLength("abccccdd") );
    }


    private int longestPalindromeStringLength(String word){
        Set<String> words = new HashSet<>();
        for(int i = 0; i<word.length(); i++){
            for(int j = i; j<word.length(); j++){

                String first = word.substring(0,j);
                String second = word.charAt(j) + word.substring(j+1, word.length());
                String third = word.charAt(i)+first;
                String four = word.charAt(i)+second;
                if(isPalindromeString(first)) {
                    words.add(first);
                }

                if(isPalindromeString(second)) {
                    words.add(second);
                }

                if(isPalindromeString(third)) {
                    words.add(first);
                }

                if(isPalindromeString(four)) {
                    words.add(second);
                }
            }




        }
        int longestLength = 0;
        for (String palindromeString: words){
            if(palindromeString.length() > longestLength){
                longestLength = palindromeString.length();
            }
        }
        return longestLength;
    }

    private boolean isPalindromeString(String word){
        int j = word.length() -1;
        for(int i =0 ;i<word.length()/2; i++){
            if(word.charAt(i) != word.charAt(j)){
                return false;
            }
            j--;
        }
        return true;
    }
}
