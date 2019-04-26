package arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : Wissen Solutions.
 * Problem Statement : Given a string S, count the number of distinct, non-empty subsequences of S .

    Since the result may be large, return the answer modulo 10^9 + 7.
    Example 1:
        Input: "abc"
        Output: 7
        Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".

    Example 2:
        Input: "aba"
        Output: 6
        Explanation: The 6 distinct subsequences are "a", "b", "ab", "ba", "aa" and "aba".

    Example 3:
        Input: "aaa"
        Output: 3
        Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".
 *
 */
public class DistinctSubSequences {
    @Test
    public void testHealthy() {
        Set<String> list = getSubSequnceList("abc");
        System.out.println(list);
    }

    private Set<String> getSubSequnceList(String s1){
        char[] chars = s1.toCharArray();
        Set<String> stringList = new HashSet<>();
        for(int i = 0; i <= chars.length; i++){
            for(int j=i+1; j<=chars.length; j++){
                stringList.add( s1.substring(i, j));
            }
        }
        return stringList;
    }
}
