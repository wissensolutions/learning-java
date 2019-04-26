package arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class SearchInsertPosition {
    @Test
    public void testHealthy() {
        Assert.assertEquals(2,searchInsert(new int[]{1,2},3));
        Assert.assertEquals(4,searchInsert(new int[]{1,3,5,6},7));
        Assert.assertEquals(1,searchInsert(new int[]{1,3,5,6},2));
    }
    public int searchInsert(int[] nums, int target){
        if(nums[0]>=target ){
            return 0;
        } else if(nums[nums.length-1] == target ){
            return nums.length-1;
        }else if(nums[nums.length-1] < target ){
            return nums.length;
        }
        return findElement(nums,0, nums.length, target);

    }

    private int findElement(int[] nums,int low, int end, int target){

        while(low<=end) {
            int mid = low + (end-low)/2;
            if(nums[mid] == target ) {
                return mid;
            } else if(nums[mid] < target && target < nums[mid+1]) {
                return mid+1;
            } else if(nums[mid] > target) {
                end = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

//    public int searchInsert(int[] nums, int target) {
//
//        return findElement(nums,0, nums.length-1,target);
//    }
//    private int findElement(int[] nums,int low, int high, int target){
//
//
//        int mid = (low + high)/2;
//        if(mid == low || mid == high){
//
//        }
//        if(nums[mid] == target ){
//            return mid;
//        }else if(nums[mid] < target){
//            return findElement(nums,mid,high,target );
//        } else {
//            return findElement(nums,low,mid,target );
//        }
//
//    }

}
