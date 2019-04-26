package sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class FindMinVersion {
    @Test
    public void testHealthy() {
        Assert.assertTrue(firstBadVersion(5) == 4);
    }

    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high-low)/2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isBadVersion(long n){
        if (n>= 4){
            return true;
        }
        return false;
    }

}
