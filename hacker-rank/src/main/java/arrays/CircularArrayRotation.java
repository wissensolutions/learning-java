package arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class CircularArrayRotation {
    @Test
    public void testHealthy() {
        Assert.assertArrayEquals(new int[]{5,3},circularArrayRotation(new int[]{3,4,5},2, new int[]{1,2}));
    }

    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int[] newArr = new int[queries.length];
        int[] b = new int[a.length];
        int n = a.length-1;
        for(int i=0;i<a.length; i++ ){
            int m = i+k > n ? Math.abs(n-(i+k)): n-1 - (i+k);
            b[i] = a[m];
        }
        for(int i=0; i< queries.length;i++ ){
            newArr[i] = b[queries[i]];
        }
        return newArr;
    }

}
