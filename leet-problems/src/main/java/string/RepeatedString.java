package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class RepeatedString {
    @Test
    public void testHealthy() {
        Assert.assertEquals(4, repeatedString("abcac", 10));
        Assert.assertEquals(7, repeatedString("aba", 10));
        Assert.assertEquals(1000000000000l, repeatedString("a", 1000000000000l));
    }

    private long repeatedString(String s, long n) {
        if(s == null || s.length()==0)
        return 0;

        long count = 0;

        for(int j=0; j<s.length(); j++){
            if(  s.charAt(j) == 'a'){
                count++;
            }
        }
        count = n/s.length()* count;
        for(int j=0; j< n % s.length(); j++){
            if(  s.charAt(j) == 'a'){
                count++;
            }
        }

        return count;

    }

}
