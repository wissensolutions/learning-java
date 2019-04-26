package map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Wissen Solutions.
 */
public class RansomNote {
    @Test
    public void testHealthy() {
        String[] s1 = {"two", "times",  "three", "is", "not", "four"};
        String[] s2 = {"two", "times",  "two", "is",  "four"};
        checkMagazine(s1,s2);
    }
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> map = new HashMap<>();
        for (String word:magazine) {
            map.compute(word, (k,v)-> v == null? 1: v+1);
        }
        for (String word:note) {
            if(!map.containsKey(word)){
                System.out.println("No");
                return;
            } else {
                map.compute(word, (k,v)-> v == 1? map.remove(word): v-1);
            }
        }
        System.out.println("Yes");
    }

}
