package arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * @author : Wissen Solutions.
 */
public class FindDuplicates {
    @Test
    public void testHealthy() {
        List<Integer> r = findDuplicates(new int[]{4,3,2,7,8,2,3,1});
        System.out.println(r);
    }

//    public List<Integer> findDuplicates(int[] nums) {
//        List<Integer> dList = new ArrayList<>();
//        for(int i =0; i< nums.length; i++){
//            if(i <= nums[i]) {
//                int j = nums[i];
//                swap(nums, i, j );
//                int k = nums[j -1];
//                swap(nums, j , k - 1);
//                swap(nums, k - 1, i);
//                if (nums[i] == nums[k - 1]) {
//                    dList.add(nums[i]);
//                }
//            }
//        }
//        return dList;
//    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null)
            return result;
        for(int i=0; i<nums.length; i++){
            int location = Math.abs(nums[i])-1;
            if(nums[location] < 0){
                result.add(Math.abs(nums[i]));
            }else{
                nums[location] = -nums[location];
            }
        }
        for(int i=0; i<nums.length; i++)
            nums[i] = Math.abs(nums[i]);

        return result;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
