package strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Problem04
 * Reverse vowels in a given string
 * 1.Input : hello
 *   Output : holle
 * 2.Input : hello world
 *  Output : hollo werld
 *
 * @author WissenSolutions.
 */
public class Problem04 {
    private static final Logger logger = LoggerFactory.getLogger(Problem04.class);
    private static List<Character> vowelCharString = Arrays.asList('a','e','i','o','u');
    public static void main(String[] args) {
        logger.info(reverseVowels("hello"));
        logger.info(reverseVowels("hello world"));
    }

    private static String reverseVowels(String word){
        char[] charArray = word.toCharArray();
        int j = charArray.length-1;
        for(int i=0; i<charArray.length && j>=0; i++){
            char currentChar = word.charAt(i);
            if(vowelCharString.contains(currentChar) || vowelCharString.contains(word.charAt(j))){
                char temp = word.charAt(j);
                charArray[j]= word.charAt(i);
                charArray[i] = temp;
            }
            j--;
        }
        return String.valueOf(charArray);
    }
}
