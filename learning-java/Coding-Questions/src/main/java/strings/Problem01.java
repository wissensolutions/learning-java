package strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Problem01
 * Anagram : Two words are said to be anagrams, if they have same number of characters,
 * but are arranged at different places in both the words
 *
 * There are lot of variations to this problem. Some of them are discussed below
 * 	1. Given 2 words, find if they are anagram of each other
 * 	2. Generate all possible anagrams of a given word, anagram generated may not be a valid dictionary word.
 * 	3. Generate all possible anagrams of a given word, anagram generated has to be a valid dictionary word.
 *
 *
 * @author WissenSolutions.
 */
public class Problem01 {
    private static final Logger logger = LoggerFactory.getLogger(Problem01.class);

    public static void main(String[] args) {
        logger.info("Permutation String={}", new Problem01().generateAllAnagarams("","AAMR"));
        logger.info("isAnagramStrings ={}", new Problem01().validateAnagramString("ARKM","AAMR"));
        logger.info("isAnagramStrings ={}", new Problem01().validateAnagramString("ARAM","AAMR"));
    }

    private boolean validateAnagramString(String str1, String str2){
        if(str1== null || str2 == null){
            return false;
        }

        if(str1.length() != str2.length()){
            return false;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Map<Character,Integer> countMap = new HashMap<>();
        for (char character:charArray1) {
            countMap.compute(character,(k,v)->  v == null ? 1:v+1);
        }

        for (char character:charArray2) {
            if(!countMap.containsKey(character)){
                return false;
            } else {
                countMap.computeIfPresent(character,(k,v)-> v-1);
            }
        }
        return  countMap.values().stream().allMatch(iInteger -> iInteger == 0);
    }

    private List<String> generateAllAnagarams(String prefixCharacter,String inputString){
        List<String> permutationList = new ArrayList<>();

        if (inputString.length() == 0) {
            permutationList.add(prefixCharacter);
        }
        char[] charArray = inputString.toCharArray();
        for(int i=0; i<charArray.length; i++){
            // Take ith character
            String prefixChar = prefixCharacter + inputString.charAt(i);
            permutationList.addAll(generateAllAnagarams(prefixChar,inputString.substring(0,i)+inputString.substring(i+1)));

        }
        return permutationList;
    }
}
