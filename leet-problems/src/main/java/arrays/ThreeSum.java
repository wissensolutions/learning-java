package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Wissen Solutions.
 */
public class ThreeSum {
    @Test
    public void testHealthy() {
        List<List<Integer>> list= threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        Assert.assertTrue(list.size()==2);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();

        for(int i=0; i<nums.length-2; i++) {
            if( i==0 || ( i > 0 && nums[i] != nums[i-1])) {
                int left = i+1;
                int right = nums.length - 1;
                int half = - nums[i];
                while(left < right) {
                    if(nums[left] + nums[right] == half) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while(left < right && nums[right-1] == nums[right]) {
                            right--;
                        }
                        left++; right--;
                    } else if(nums[left] + nums[right] < half) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    private boolean isExist(List<Integer> list, Map<String, Boolean> map2){
        StringBuilder sb = new StringBuilder();
        List<Integer> list1 = list;
        Collections.sort(list1);
        for(Integer item : list1){
            sb.append(item);
        }
        if(!map2.containsKey(sb.toString())){
            map2.put(sb.toString(), true);
            return false;
        }
        return true;
    }
}
