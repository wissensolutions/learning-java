package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author : Wissen Solutions.
 */
public class SherlockAnagram {
    @Test
    public void testHealthy() {
        Assert.assertEquals(4, findUnorderedAnagramPairNum("abba"));
    }
    static int findUnorderedAnagramPairNum(String str) {
        Map<String, Integer> anagramMap = new HashMap<>();
        for(int i= 0; i< str.length(); i++){
            // As subString excludes end index, we need to add +1 to length to cover last character
            for(int j = i+1; j <= str.length(); j++){
                String sortedString = sortString(str.substring(i,j));
                // Check whether its exist in Map
                anagramMap.compute(sortedString, (k,v)-> v== null ? 1: v+1);
            }
        }
        // By this time, Map will have sorted String and corresponding count
        // For each possibility, we need to find possible anagram counts
        return anagramMap.values().stream().mapToInt(v-> v * (v-1)/2).sum();
    }

    private static String sortString(String s1){
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }


}
