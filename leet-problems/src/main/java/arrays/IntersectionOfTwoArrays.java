package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Wissen Solutions.
 */
public class IntersectionOfTwoArrays {
    @Test
    public void testHealthy() {
        Assert.assertEquals("[2, 2]",Arrays.toString(intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        // First sort two arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] temp = new int[Math.min(nums1.length,nums2.length)];

        int i = 0, j=0, k=0;
        while(i<nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                temp[k] = nums1[i];
                k++;
                i++;
                j++;
                continue;
            }
            if(nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(temp,0,k);
    }
}
