package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : Wissen Solutions.
 */
public class MinimunSwaps2 {
    @Test
    public void testHealthy() {
        Assert.assertEquals(5, solve(new int[]{7,1,3,2,4,5,6}));
    }

    static int solve(int[] arr) {
        Map<Integer, Integer> numberToIndex = new HashMap<>();
        for(int i=0; i< arr.length; i++){
            numberToIndex.put(arr[i], i);
        }

        int swapNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                int currentIndex = numberToIndex.get(i + 1);
                // Swap the current index in the map
                numberToIndex.put(arr[i], currentIndex);
                numberToIndex.put(i + 1, i);

                swap(arr, i, currentIndex);

                swapNum++;
            }
        }
        return swapNum;
    }
    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
