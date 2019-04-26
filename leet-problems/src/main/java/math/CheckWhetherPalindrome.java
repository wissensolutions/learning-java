package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class CheckWhetherPalindrome {
    @Test
    public void testHealthy() {
        Assert.assertTrue( isPalindrome(121));
        Assert.assertFalse( isPalindrome(-121));
        Assert.assertFalse( isPalindrome(10));
        Assert.assertFalse( isPalindrome(16616));
        Assert.assertTrue( isPalindrome(0));
    }

    private boolean isPalindrome(int x) {
        if(x == 0){
            return true;
        }
        if( x < 0 || x % 10 == 0){
            return false;
        }
        return x == reverse(x);
    }
    private int reverse(int x){
        long result = 0;
        while( x != 0){
            result = result * 10 + x % 10;
            x = x/10;
        }
        if(result > Integer.MAX_VALUE){
            return 0;
        }
        return (int)result;
    }
}
