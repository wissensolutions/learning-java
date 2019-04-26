package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.TreeMap;

/**
 * * <br> Problem Statement :
 *
 * Given a string which consists of lower case or upper case letters, find the length of the longest palindrome that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note: Assume the length of given string will not exceed 1,010.
 *
 * Example:
 * Input: "abccccdd"
 * Output: 7
 *
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * @author : Wissen Solutions.
 */
public class FindingLengthOfLongestPalindrome {
    @Test
    public void testHealthy() {
        Assert.assertEquals(7, lengthOfLongestPalindrome("abccccdd"));
    }

    private TreeMap<String,Integer> permutationMap = new TreeMap<>((o1, o2) -> {
        if(o1.length() < o2.length()){
            return 1;
        }else if(o1.length() > o2.length()){
            return -1;
        } else {
            return 0;
        }
    });
    private int lengthOfLongestPalindrome(String word){

        for(int i=0; i< word.toCharArray().length; i++){
            findProbableString(word.substring(0,i));
            findProbableString(word.substring(i));
        }
        return permutationMap.pollFirstEntry().getValue();
    }

    private void findProbableString(String word){
        for(int i=0; i < word.length(); i++){
            String s1 = word.substring(0,i);
            String s2= word.substring(i);
            if(isPalindromeString(s1)){
                permutationMap.put(s1, s1.length());
            }
            if(isPalindromeString(s2)){
                permutationMap.put(s2, s2.length());
            }

        }
    }
    private boolean isPalindromeString(String word){
        if(word.equalsIgnoreCase("dccaccd")){
            //do nothing;
        }
        if(word == null || word.length() == 0 ){
            return false;
        }
        char[] chars = word.toCharArray();
        int j = chars.length-1;
        for(int i=0; i<chars.length/2; i++){
            if( chars[i] != chars[j]){
                return false;
            }
            j--;
        }
        return true;
    }
}
