package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 * @author : Wissen Solutions.
 */
public class AlienDictionaryVerification {
    @Test
    public void testHealthy() {
        Assert.assertFalse(isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
        Assert.assertTrue(isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        Assert.assertFalse(isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
    }
    public boolean isAlienSorted(String[] words, String order) {
        char[] orderArr = order.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0; i<orderArr.length;i++){
            map.put(orderArr[i],i+1);
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                char[] sArr1 = s1.toCharArray();
                char[] sArr2 = s2.toCharArray();
                int length = sArr1.length >= sArr2.length ?sArr2.length: sArr1.length;

                for(int i =0; i<length;i++){
                    if(map.get(sArr1[i]) > map.get(sArr2[i])){
                        return 1;
                    } else if(map.get(sArr1[i]) < map.get(sArr2[i])){
                        return -1;
                    }else if(map.get(sArr1[i]) == map.get(sArr2[i])){
                        continue;
                    }

                }
                if(sArr1.length > sArr2.length){
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        String[] newWordArr = Arrays.copyOf(words,words.length);
        Arrays.sort(words,comparator);
        return Arrays.equals(newWordArr, words);
    }

}
