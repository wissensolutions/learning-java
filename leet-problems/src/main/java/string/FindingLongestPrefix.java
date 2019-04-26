package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Wissen Solutions.
 */
public class FindingLongestPrefix {
    @Test
    public void testHealthy() {
        String[] ss = new String[]{"dog","racecar","car"};
        Assert.assertEquals("fl",longestCommonPrefix(ss));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String minString = null;
        int minLength = -1;

        for(int i = 0;i<strs.length; i++){

            if(minLength == -1 || strs[i].length() <  minLength){
                minLength = strs[i].length();
                minString = strs[i];
            }

        }

        char[] chars = minString.toCharArray();
        char[] temp = new char[minLength];



        temp = getCommonArray(chars, strs,temp);

        if(temp.length==0){
            return "";
        }
        return new String(temp);

    }

    private char[] getCommonArray(char[] chars, String[] strs, char[] temp){

        int k =0;
        boolean isMatch = true;
        for(int i = 0;i<chars.length; i++){
            for(String s : strs){
                if(chars[i]!= s.charAt(i)) {
                    isMatch = false;
                    break;
                }
            }
            if(!isMatch){
                return Arrays.copyOfRange(temp,0,k);
            } else {
                temp[k] = chars[i];
                k++;
            }

        }
        return temp;


    }
}
