package javaproblems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <br> Problem Statement :
 *
 * Design a method to find the frequency of occurrences
 * of any given word in a book. What if we were running
 * this algorithm multiple times?
 *
 * </br>
 * Learning
 *
 * @author WissenSolutions.
 */
public class Problem03 {
    private static final Logger logger = LoggerFactory.getLogger(Problem03.class);

    public static void main(String[] args) {
        Problem03 object = new Problem03();
        Map<String,Integer> dictionary = new HashMap<>();
        object.setupDictionaryWithCompute(dictionary, Arrays.asList("This is sample word. This word contains many alphabets.".split(" ")));
        object.setupDictionaryWithCompute(dictionary, Arrays.asList("This is sample word. This word contains vowels and consonants".split(" ")));
        logger.info("Count={}", object.getCountOfWordOccurances(dictionary,"This"));
    }

    private int getCountOfWordOccurances(Map<String,Integer> dictionary, String word){
        int returnCount = 0;
        if(dictionary.containsKey(word)){
            returnCount = dictionary.get(word);
        }
        return returnCount;
    }
    private Map<String,Integer> setupDictionary( Map<String,Integer> dictionary, List<String> wordList){

        wordList.stream().forEach(item -> {
            int count = 0;
            if(dictionary.containsKey(item)){
                count = dictionary.get(item);
            }
            count++;
            dictionary.put(item,count);
        });
        return dictionary;
    }

    private Map<String,Integer> setupDictionaryWithCompute( Map<String,Integer> dictionary, List<String> wordList){

        wordList.stream().forEach(item -> {
            dictionary.compute(item,(k,v)-> (v==null) ? 1: v+1);
        });
        return dictionary;
    }

}
