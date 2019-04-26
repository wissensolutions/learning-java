package arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class FindingNonDuplicateElement {
    @Test
    public void testHealthy() {
        Assert.assertEquals(1, singleNumber( new int[]{2,2,1}, 3));
    }

    int singleNumber(int A[], int n) {
        int result = 0;
        for (int i = 0; i<n; i++)
        {
            result ^=A[i];
        }
        return result;
    }
}
