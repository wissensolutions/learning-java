package arraysandstrings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem01
 * Learning
 * <p>
 *     @author WissenSolutions.
 */
public class Problem01 {
    private static final Logger logger = LoggerFactory.getLogger(Problem01.class);
    public static void main(String[] args ){
        String case1 = "tes";
        String case2 = "dsfsddf";
        logger.info("isUniqueCharacterString(case1)={}", isUniqueCharacterString(case1));
        logger.info("isUniqueCharacterString(case2)={}", isUniqueCharacterString(case2));

    }

    private static boolean isAsciiUniqueCharacterString(String inputString){
        if( inputString == null || inputString.length()==0 || inputString.length()>256){
            return false;
        }
        char[] chars = inputString.toCharArray();
        boolean[] indexArray = new boolean[chars.length];
        for(int i=0; i<chars.length; i++){
            int charNumericValue = chars[i];
            if(!indexArray[charNumericValue]) {
                indexArray[charNumericValue] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isUniqueCharacterString(String inputString){

        if( inputString == null || inputString.length()==0 ){
            return false;
        }

        char[] charArray = inputString.toCharArray();
        boolean isDuplicateExist = false;
        Set<Character> characterSet = new HashSet<>();
        for (char eachChar : charArray){
            if( !characterSet.contains(eachChar)){
                characterSet.add(eachChar);
            } else {
                return  false;
            }

        }
        return true;
    }
}
