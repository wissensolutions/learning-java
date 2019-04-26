package arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class BeautifulDaysAtMovies {
    @Test
    public void testHealthy() {
        Assert.assertEquals(2, beautifulDays(20,23,6));
    }

    static int beautifulDays(int i, int j, int k) {
        int count = 0;
        for(int m = i; m<=j; m++){
            if((m-reverseNum(m)) % k ==0 ){
                count++;
            }
        }
        return count;

    }
    private static long reverseNum(int num){
        long returnVal = 0;
        while(num != 0){
            returnVal = returnVal * 10 + num % 10 ;
            num = num / 10;
        }
        return returnVal;
    }

}
