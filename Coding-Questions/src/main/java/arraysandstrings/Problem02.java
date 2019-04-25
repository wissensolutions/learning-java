package arraysandstrings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem02
 * Learning
 * <p>
 * @author WissenSolutions.
 */
public class Problem02 {
    private static final Logger logger = LoggerFactory.getLogger(Problem02.class);
    public static void main(String[] args ){
        logger.info("isPermutationCheckWithString(case1)={}", isPermutationCheckWithString("test","ttes"));
        logger.info("isPermutationCheckWithAsciiCharacterString(case2)={}", isPermutationCheckWithAsciiCharacterString("test", "ttrs"));
        logger.info("isPermutationCheckWithAsciiCharacterString(case2)={}", isPermutationCheckWithAsciiCharacterString("test", "ttes"));

    }

    private static boolean isPermutationCheckWithString(String inputString1, String inputString2){
        //if both string lengths are not equal, then those are not permutation strings
        if(inputString1 == null || inputString2 == null || inputString1.length()==0 || inputString2.length()==0 || inputString1.length()!=inputString2.length()){
            return false;
        }

        char[] charArray1 = inputString1.toCharArray();
        char[] charArray2 = inputString2.toCharArray();
        //Sort them
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        if(!new String(charArray1).equalsIgnoreCase(new String(charArray2))){
            return false;
        } else {
            return true;
        }
    }

    private static boolean isPermutationCheckWithAsciiCharacterString(String inputString1, String inputString2){
        //if both string lengths are not equal, then those are not permutation strings
        if(inputString1 == null || inputString2 == null || inputString1.length()==0 || inputString2.length()==0 || inputString1.length()!=inputString2.length()){
            return false;
        }

        char[] charArray1 = inputString1.toCharArray();
        char[] charArray2 = inputString2.toCharArray();

        //First convert char array to int array (contains ascii values)
        int[] aschiNumArray = new int[256];
        for(int i=0; i<charArray1.length; i++){
            aschiNumArray[charArray1[i]]++;
        }

        //Second take second char array, iterate and verify if that value contained in the previous array. If not return false;
        for(int i=0;i<charArray2.length; i++){
            if(aschiNumArray[charArray2[i]] < 0){
                return false;
            }
        }
        return true;
    }
}
