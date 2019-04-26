package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *  * <br> Problem Statement :
 *
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *
 * @author : Wissen Solutions.
 */
public class RotateAnArray {
    @Test
    public void testHealthy() {
        int[] array = {1,2,3,4,5,6,7};
        rotate(array, 3);

        Assert.assertEquals("[5, 6, 7, 1, 2, 3, 4]", Arrays.toString(array));
    }
//    private int[] rotateAnArray(int[] nums, int k){
//        for(int j= 0; j< k; j++) {
//            int temp = nums[nums.length-1];
//            for (int i = nums.length-2; i>=0; i--) {
//                nums[i+1] = nums[i];
//            }
//            nums[0] = temp;
//        }
//        return nums;
//    }
//    private void rotateAnArray(int[] nums, int k){
//        int[] a2 = new int[k];
//        int[] result = new int[nums.length];
//        System.arraycopy(nums,nums.length - k,result,0,k);
//        System.arraycopy(nums,0,result,k,nums.length - k);
//        System.arraycopy(result,0,nums,0,nums.length);
//
//    }

    public void rotate(int[] nums, int k) {
        if(k==0 || nums.length <2) return;
        int len = nums.length;
        int r = k % len;
        int[] temp = new int[len];
        for(int j=0; j<len; j++){
            temp[(j+r)%len] = nums[j];
        }
        System.arraycopy(temp, 0, nums, 0, temp.length);
    }

    private void rotateAnArrayWithJugglingAlg(int[] arr, int d){

        int n = arr.length;
        int gcd = findGCD(d,n);
        int i, j, k, temp;
        for (i = 0; i < gcd; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }

    }

    private int findGCD(int a, int b){
        if(b == 0){
            return a;
        }
        return findGCD(b, a%b);
    }
//
//    public void rotate(int[] nums, int k) {
//        if(k == 0) return;
//        int i,j,r,temp;
//        int n = nums.length;
//        k = k > n ? n - k%n : n-k;
//        for(i = 0; i < gcd(n,k); i++){
//            r = (i+k) % n;
//            temp = nums[i];
//            for(j = i; r != i; r = (j+k) % n){
//                nums[j] = nums[r];
//                j = r;
//            }
//            nums[j] = temp;
//        }
//    }
    public int gcd(int x, int y){
        return y== 0 ? x : gcd(y, x%y);
    }

}
