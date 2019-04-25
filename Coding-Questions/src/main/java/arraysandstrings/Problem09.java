package arraysandstrings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Problem09
 * <br> Problem Statement :
 *
 * Assume you have a method isSubstring which checks
 * if one word is a substring of another. Given two
 * strings s1 and s2, write code to check if s2 is
 * a rotation of s1 using only one call to isSubstring.
 *
 * ex. "waterbottle" is a rotation of "erbottlewat"
 *
 * </br>
 *
 * @author WissenSolutions.
 */
public class Problem09 {
    private static final Logger logger = LoggerFactory.getLogger(Problem09.class);

    public static void main(String[] args) {
        logger.info("value={}",isRotatedSubString("waterbottle", "erbottlewat" ));
    }

    private static boolean isRotatedSubString(String s1, String s2){
        if(s1 == null || s2 == null){
            return false;
        }

        if(s1.length() != s2.length()){
            return false;
        } else {
            //TODO need to check this logic
            return isSubString(s1.concat(s2), s2);
        }
    }

    private static boolean isSubString(String s1, String s2){
        if(s1.toLowerCase().indexOf(s2.toLowerCase())>1){
            return true;
        }
        return false;
    }
}
