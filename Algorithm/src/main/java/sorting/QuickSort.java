/**
 * Class for InsertionSort implementation
 *
 */
package sorting;

import java.util.Arrays;


public class QuickSort extends Sort{
    @Override
    int[] doSort(int[] inputArr) {
        return implementQuickSort(inputArr,0, inputArr.length-1);
    }

    private int[] implementQuickSort(int[] values, int lowestPosition, int higestPosition){
        int pivotElement = values[lowestPosition+(higestPosition-lowestPosition)/2] ;
        int i = lowestPosition;
        int j = higestPosition;
        //Take first element from left side and compare with Pivot element
        while(values[i]<pivotElement){
            i++;
        }
        //Take last element from right side and compare with Pivot element
        while (values[j]>pivotElement){
            j--;
        }

        //if the left side element is greater than pivot element and
        //the right side element is less than pivot element then swap
        // these two elements
       if(i<=j){
            int temp = values[j];
            values[j] = values[i];
            values[i] = temp;
            i++;
            j--;
        }

        //call this method recursively until i < high or j <low
        if(lowestPosition < j){
           implementQuickSort(values,lowestPosition, j);
        }
        if(i < higestPosition){
            implementQuickSort(values,i, higestPosition);
        }
        return values;
    }
}
