package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Wissen Solutions.
 */
public class LongestSubString {
    @Test
    public void testHealthy() {
        Assert.assertEquals(3,lengthOfLongestSubstring("pwwkew"));
    }

//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        int ans = 0, i = 0, j = 0;
//        while (i < n && j < n) {
//            // try to extend the range [i, j]
//            if (!set.contains(s.charAt(j))){
//                set.add(s.charAt(j++));
//                ans = Math.max(ans, j - i);
//            }
//            else {
//                set.remove(s.charAt(i++));
//            }
//        }
//        return ans;
//    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxSubStringLength = 0;
        int j = 0;
        Map<Character, Boolean> map = new HashMap<>();
        for(int i=0; i<chars.length && j < chars.length; ){

            // Duplicate occurred

            if(map.containsKey(chars[j])){
                maxSubStringLength = maxSubStringLength < (j-i) ? (j-i) : maxSubStringLength;
                i++;
                map.remove(chars[j]);
            } else {

                map.put(chars[j], true);
                j++;
            }
        }
        return maxSubStringLength;
    }


}
