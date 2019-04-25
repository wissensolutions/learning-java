package arraysandstrings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * /**
 * <br> Problem Statement :
 *
 * Given a string, write a function to check if it is a
 * permutation of a palindrome. A palindrome is a word
 * or phrase that is same forwards and backwards. A
 * permutation is a rearrangement of letters. The palindrome
 * does not need to be limited to just dictionary words.
 *
 * ex. Input : Tact Coa
 * Output : True (permutations : "taco cat", "atco cta", etc.)
 *
 * </br>
 *
 * Learning
 *
 * @author WissenSolutions.
 */
public class Problem04 {
    private static final Logger logger = LoggerFactory.getLogger(Problem03.class);
    public static void main(String[] args) {
        // Palondrome string is Tac o cat
        logger.info("isPalendromePermutationString={}",isPalendromePermutationString("Tact Coa"));

        logger.info("isPalendromePermutationString={}",isPalendromePermutationString("wissen solutions"));
    }

    /**
     * 1. Palondrome String :
     * @param inputString the given string value
     * @return {@link boolean}
     */
    private static boolean isPalendromePermutationString(String inputString){
        Map<Character,Integer> characterIntegerMap = new HashMap<>();

        //Converting String to lower case to avoid comparision problems
        inputString = inputString.toLowerCase();
        char[] charArray = inputString.toCharArray();

        for(int i=0;i<charArray.length; i++){
            char character = charArray[i];
            if(Character.isLetter(character) || Character.isDigit(character)) {
                Integer characterCount = characterIntegerMap.get(character);
                if (characterCount != null) {
                    characterIntegerMap.put(character, characterCount + 1);
                } else {
                    characterIntegerMap.put(character, 1);
                }
            }
        }
        int oddCount = 0;
        for (char key : characterIntegerMap.keySet()){
            if (characterIntegerMap.get(key) %2 !=0 ){
                oddCount++;
            }
        }
        // we will have atleast one odd character. If we have more than one, then it's not palindrome String
        if (oddCount >1){
            return false;
        }
        return true;
    }
}
