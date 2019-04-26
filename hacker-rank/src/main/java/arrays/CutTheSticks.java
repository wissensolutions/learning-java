package arrays;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Wissen Solutions.
 */
public class CutTheSticks {
    @Test
    public void testHealthy() {
        int[] r = cutTheSticks(new int[]{8, 8, 14, 10, 3, 5, 14, 12});
        System.out.println(Arrays.toString(r));
    }

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        int[] list = new int[arr.length-1];
        int i =1;
        list[0] = arr.length;
        while(true){
            int leftCount = breakSticks(arr);
            list[i++] = leftCount;

            if(leftCount <= 1){
                break;
            }

        }
        return Arrays.copyOf(list,i);

    }
    private static int breakSticks(int[] arr){
        int min = findMinElement(arr);
        int leftCount = 0;
        boolean allAreMin = true;
        for(int i =0; i<arr.length; i++ ){
            arr[i] = arr[i] - min;
            if(arr[i] > 0){
                if(arr[i] != min){
                    allAreMin = false;
                }
                leftCount++;
            } else {
                arr[i] = 0;
            }
        }
        return allAreMin ? 1 : leftCount;
    }
    private static int findMinElement(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i =0;i<arr.length; i++){
            if(arr[i] != 0 && arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }


}
