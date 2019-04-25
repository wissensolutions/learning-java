package strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * AnagaramString
 *
 * Anagram : Two words are said to be anagrams, if they have same number of characters,
 * but are arranged at different places in both the words
 *
 * There are lot of variations to this problem. Some of them are discussed below
 * 	1. Given 2 words, find if they are anagram of each other
 * 	2. Generate all possible anagrams of a given word, anagram generated may not be a valid dictionary word.
 * 	3. Generate all possible anagrams of a given word, anagram generated has to be a valid dictionary word.
 *
 * @author WissenSolutions.
 */
public class AnagaramString {
    private static final Logger logger = LoggerFactory.getLogger(AnagaramString.class);

    private static boolean isAnagramString(String word1, String word2){

        if(word1.length() != word2.length()){
            return false;
        }

        Map<Character,Integer> map = new HashMap<>();
        char[] chars = word1.toCharArray();
        for (char aChar : chars) {
            map.compute(aChar,(k,v)->  v == null ? 1: v+1 );
        }

        chars = word2.toCharArray();
        for (char aChar : chars) {
            if(!map.containsKey( aChar)  ){
                return false;
            } else {
                map.computeIfPresent(aChar, (k,v)-> {
                    if(v == 1) {
                        map.remove(aChar);
                        return 0;
                    } else {
                        return v -1 ;
                    }
                });
            }
        }
        if(map.size() >= 1){
            return false;
        }
        return true;

    }

    private static boolean isAnagramString_bySorting(String word1, String word2){

        if(word1.length() != word2.length()){
            return false;
        }

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i=0;i < chars2.length; i++) {
            if(chars1[i] != chars2[i]){
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagramString_UsingAsciiCharacter(String word1, String word2){

        if(word1.length() != word2.length()){
            return false;
        }

        int result1 = 0, result2 = 0;
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();


        for (int i=0;i < chars1.length; i++) {
            result1 += chars1[i];
        }

        for (int i=0;i < chars2.length; i++) {
            result2 += chars2[i];
        }
        if(result1 == result2){
            return true;
        } else {
            return false;
        }
    }

    private static Set<String> generateAnagramStrings( String word) {
        if( word == null || word.length() == 0){
            return null;
        }
        return generateAnagramStringsRecursive("", word);
    }

    private static Set<String> generateAnagramStringsRecursive( String prefix, String word) {
        Set<String> list = new HashSet<>();
        if( word == null || word.length() == 0){
            list.add(prefix);
            return list;
        }
        for(int i=0;i<word.length() ; i++){
            String newPrefix = prefix + word.charAt(i);
            String newWord = word.substring(0, i) + word.substring(i+1, word.length());
            list.addAll(generateAnagramStringsRecursive(newPrefix, newWord));
        }
        return list;
    }

    private static Set<String> generateAnagramStringsWithoutRecursive( String word) {
        Set<String> list = new HashSet<>();
        if( word == null || word.length() == 0){
            return null;
        }

        for (int k = 0; k < word.length(); k++) {
            for (int i = 0; i < word.length(); i++) {
                String newWord = word.charAt(k) + word.substring(0, i) + word.substring(i+1 , word.length());
                list.add(newWord);
            }
        }
        return list;
    }
    public static void main(String[] args){
        logger.info(" word1 = {} and word2 = {} are anagram strings. {}", "test","ttes",isAnagramString("test", "ttes"));
        logger.info(" word1 = {} and word2 = {} are anagram strings. {}", "test","ttks",isAnagramString("test", "ttks"));

        logger.info(" word1 = {} and word2 = {} are anagram strings. {}", "test","ttes",isAnagramString_bySorting("test", "ttes"));
        logger.info(" word1 = {} and word2 = {} are anagram strings. {}", "test","ttks",isAnagramString_bySorting("test", "ttks"));

        logger.info(" word1 = {} and word2 = {} are anagram strings. {}", "test","ttes",isAnagramString_UsingAsciiCharacter("test", "ttes"));
        logger.info(" word1 = {} and word2 = {} are anagram strings. {}", "test","ttks",isAnagramString_UsingAsciiCharacter("test", "ttks"));

        logger.info("Anagram List = {}", generateAnagramStrings("test"));
        logger.info("Anagram List = {}", generateAnagramStringsWithoutRecursive("test"));
    }
}
