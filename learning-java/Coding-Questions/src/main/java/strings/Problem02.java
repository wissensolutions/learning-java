package strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Problem02
 * Reverse words in a string
 * Approach : Split the word by space and then reverse
 *
 * @author WissenSolutions.
 */
public class Problem02 {
    private static final Logger logger = LoggerFactory.getLogger(Problem02.class);

    public static void main(String[] args) {
        logger.info(new Problem02().reverseWords("This is my name"));
    }

    private String reverseWords(String sentence){
        String[] words = sentence.split("\\s");
        StringBuilder sentenceBuilder = new StringBuilder();
        for(String word : words){
            StringBuilder charBuilder = new StringBuilder();
            char[] charArray = word.toCharArray();
            for(int i=charArray.length-1;i>=0;i--){
                charBuilder.append(word.charAt(i));
            }
            sentenceBuilder.append(" "+charBuilder.toString());
        }
        return sentenceBuilder.toString();
    }

}
