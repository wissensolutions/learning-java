package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 * Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical
digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
Thefore INT_MIN (−231) is returned.
 */
public class StringToInteger {
    @Test
    public void testHealthy() {
//        Assert.assertEquals(42, stringToInt("42"));
//        Assert.assertEquals(-42, stringToInt(" -42"));
//        Assert.assertEquals(4193, stringToInt("4193 with words"));
//        Assert.assertEquals(0, stringToInt("words and 987"));
//        Assert.assertEquals(-2147483648, stringToInt("-91283472332"));
        Assert.assertEquals(2147483647, stringToInt("9223372036854775808"));
//        Assert.assertEquals(0, stringToInt(" "));
//        Assert.assertEquals(3, stringToInt("3.14159"));
//        Assert.assertEquals(0, stringToInt("+-2"));
//        Assert.assertEquals(2, stringToInt("+2"));
    }

    private int stringToInt(String str){
        if(str == null || str.trim().length() == 0){
            return 0;
        }
        String input = str.trim();
        char[] chars = input.toCharArray();
        if((chars[0] >= 65 && chars[0] <= 90) || (chars[0] >= 97 && chars[0] <= 122)){
            return 0;
        }
        boolean isNegative = false;
        if(chars[0] == '-'){
            isNegative = true;
            chars[0] = '0';
        } else if(chars[0] == '+'){
            chars[0] = '0';
        }
        long result = 0;
        for(int i=0; i<input.length();i++){

            if(Character.isDigit(chars[i])){
                result = result * 10 + chars[i] - 48;
            } else {
                break;
            }
        }

        if(isNegative) {
            result *= -1;
        }
        if(result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if(result  > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }

        return (int)result;
    }


}
