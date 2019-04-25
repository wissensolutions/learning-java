package math;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * math.FindingSquareRoot
 * Learning
 * <br> Problem Statement :
 *
 * Given a number n, find it's square root without using /
 *
 * </br>
 * @author WissenSolutions.
 */
public class FindingSquareRoot {
    private static final Logger logger = LoggerFactory.getLogger(FindingSquareRoot.class);

    @Test
    public void testHealthy(){
        Assert.assertEquals(3, findSquareRoot(9));
        Assert.assertEquals(5,findSquareRootByUsingMultiplier(25));
        Assert.assertEquals(7,findSquareRoot(49));
        Assert.assertEquals(3,findSquareRoot(8));
    }

    /**
     * Method to find the square root of a number without using /
     *
     * Time Complexity = O(log(n))
     * Space Complexity = O(1)
     *
     * @param n
     * @return {@link int}
     */
    private  int findSquareRoot(int n){
        int sum = 0;
        int iterator = 1;
        int i = 0;
        while (sum < n){
            sum = sum + iterator;
            iterator = iterator+2;
            i++;
        }
        return i;
    }

    private int findSquareRootByUsingMultiplier(int n){
        int i =1, result = 1;

        while(result < n){
            i++;
            result = i * i;
        }
        return i;
    }

}
