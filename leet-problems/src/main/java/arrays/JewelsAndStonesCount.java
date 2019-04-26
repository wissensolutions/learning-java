package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Wissen Solutions.
 */
public class JewelsAndStonesCount {
    @Test
    public void testHealthy() {
        Assert.assertEquals(3,numJewelsInStones("ebd", "bbb"));
    }

    public int numJewelsInStones(String J, String S) {
        Map<Character, Integer> jewelMap = new HashMap<>();
        char[] charArray1 = J.toCharArray();
        for(int i=0;i<J.length();i++){
            jewelMap.put(charArray1[i],Integer.MIN_VALUE);
        }
        int i=0, j=S.length()-1;
        int count = 0;
        char[] charArray = S.toCharArray();
        while(i<=j){
            if(jewelMap.containsKey(charArray[i])){
                count++;
            }
            if(jewelMap.containsKey(charArray[j]) && i != j){
                count++;
            }
            i++;
            j--;
        }
        return count;
    }
}
