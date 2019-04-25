/**
 * Class for Counting sort implementation
 * <p>
 *
 */
package sorting;

public class CountingSort extends Sort{

    @Override
    int[] doSort(int[] inputArr) {
        return implementCountingSort(inputArr);
    }

    private int[] implementCountingSort(int[] inputArr){
        int[] countArray = new int[256];
        //Initialize Count array with zero
        for(int i=1;i<countArray.length;i++){
            countArray[i] = 0;
        }

        // store count of each character
        for(int i=0;i<inputArr.length;i++){
            countArray[inputArr[i]]++;
        }

        /*Modify the count array such that each element at each index
        stores the sum of previous counts.*/
        for (int i=1;i<countArray.length;i++){
            countArray[i] += countArray[i-1];
        }
        int[] output = new int[inputArr.length];

        /*Output each object from the input sequence followed by
        decreasing its count by 1.*/
        for(int i=0; i<inputArr.length; i++){
            output[countArray[inputArr[i]]-1] = inputArr[i];
            countArray[inputArr[i]]--;
        }

        return output;
    }
}
