package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Wissen Solutions.
 *
 * <br> Problem Statement :
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1]
 *
 * </br>
 *
 */

public class TwoSums {
    @Test
    public void testHealthy() {
        int[] elementsArr = {2, 7, 11, 15};

        int[] array = returnSumIndexArray(elementsArr, 9);
        Assert.assertEquals("[0, 1]",Arrays.toString(array));
    }

    private int[] returnSumIndexArray(int[] array, int target){
        int[] returnArray = new int[2];
        Map<Integer, Integer> elementMap = new HashMap<>();
        for(int i = 0; i<array.length; i++){
            int remainingValue = target - array[i];
            if(elementMap.containsKey(remainingValue)){
                returnArray[0] = elementMap.get(remainingValue);
                returnArray[1] = i;
                return returnArray;
            } else {
                // if the map already contains this element
                if(elementMap.containsKey(array[i])){
                    continue;//There is no need to add this element
                }
                elementMap.put(array[i], i);
            }
        }
        return null;
    }
}
