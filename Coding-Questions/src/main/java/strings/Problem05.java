package strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Problem05
 * Find the length of last word
 *
 * @author WissenSolutions.
 */
public class Problem05 {
    private static final Logger logger = LoggerFactory.getLogger(Problem05.class);

    public static void main(String[] args) {
        logger.info("Length={}",lengthOfLastWord(""));
        logger.info("Length={}",lengthOfLastWord("Geeks For Geeks"));
        logger.info("Length={}",lengthOfLastWord("Start Coding Here"));
        logger.info("Length={}",lengthOfLastWordUsingCharacters("Geeks For Geeks"));
        logger.info("Length={}",lengthOfLastWordUsingCharacters("Start Coding Here"));
    }

    private static int lengthOfLastWord(String sentence){
        String[] words = sentence.split("\\s");
        return words[words.length-1].length();
    }

    private static int lengthOfLastWordUsingCharacters(String sentence){
        int count = 0;
        char[] chars = sentence.trim().toCharArray();
        for (int i=0;i<chars.length;i++){
            if((sentence.charAt(i) == ' ') || (sentence.charAt(i) == '\t')){
                count = 0;
            } else {
                count++;
            }

        }
        return count;
    }
}
