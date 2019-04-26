package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * * <br> Problem Statement :
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * </br>
 *
 * @author : Wissen Solutions.
 */
public class TwoSumWithSortedArray {
    @Test
    public void testHealthy() {
        int[] elementsArr = {2, 7, 11, 15};

        int[] array = findTwoSumWithSortedArray(elementsArr, 9);
        Assert.assertEquals("[0, 1]", Arrays.toString(array));
        Assert.assertEquals("[0, 1]", Arrays.toString(findTwoSumWithSortedArrayWithoutMap(elementsArr, 9)));
    }

    private int[] findTwoSumWithSortedArray(int[] sortedArray, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int[] returnArray = new int[2];
        for(int i=0; i < sortedArray.length; i++){
            int remainingValue = target - sortedArray[i];
            //Elements are sorted. So next element will always be greater than current element

            if(map.containsKey(remainingValue)){
                returnArray[0] = map.get(remainingValue);
                returnArray[1] = i;
                return returnArray;
            } else {
                if(remainingValue < sortedArray[i]){
                    break;
                }
                //Handling duplicate elements
                if(!map.containsKey(sortedArray[i])) {
                    map.put(sortedArray[i], i);
                }
            }
        }
        return returnArray;
    }

    private int[] findTwoSumWithSortedArrayWithoutMap(int[] sortedArray, int target){

        int low = 0, high = sortedArray.length - 1;
        while(low < high){
            int sum = sortedArray[low] + sortedArray[high];
            if(sum == target){
                return new int[]{low,high};
            } else if( sum < target){
                    low++;
            } else {
                high--;
            }
        }
        return null;
    }
}
