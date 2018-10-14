/**
 * Class for InsertionSort implementation
 *
 * Created by Amar Veerepalli
 */
package sorting;


public class SelectionSort extends Sort{
    @Override
    int[] doSort(int[] inputArr) {

        for(int i=0;i<inputArr.length-1;i++){
            int minIndex = i;
            for (int j=i+1; j<inputArr.length;j++){
                if(inputArr[j] < inputArr[minIndex]){
                    minIndex = j;
                }
            }
            // Finally move minIndex element to ith position
            int temp = inputArr[i];
            inputArr[i] = inputArr[minIndex];
            inputArr[minIndex] = temp;
        }
        return inputArr;
    }
}
