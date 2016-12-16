/**
 * Class for InsertionSort implementation
 *
 * Created by Amar Veerepalli
 */
package sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args){
        int[] valuesToBeSorted = {7, 10, 47, 40, 83, 84, 65, 61, 32, 55, 49, 46, 25, 20, 93, 63, 54, 10};
        selectionSort(valuesToBeSorted);
        Arrays.stream(valuesToBeSorted).forEach(n -> System.out.print(n + ","));

    }

    /**
     * The selection sort is a combination of searching and sorting.
     * During each pass, the unsorted element with the smallest (or largest) value is moved to its proper position in the array.
     * The number of times the sort passes through the array is one less than the number of items in the array.
     * In the selection sort, the inner loop finds the next smallest (or largest) value and
     * the outer loop places that value into its proper location.
     *
     * - See more at: http://www.java2novice.com/java-sorting-algorithms/selection-sort/#sthash.z3AacPw6.dpuf
     * Selection sort is not difficult to analyze compared to other sorting algorithms since none of the loops depend on the data in the array.
     * Selecting the lowest element requires scanning all n elements (this takesn − 1 comparisons) and then swapping it into the
     * first position. Finding the next lowest element requires scanning the remaining n − 1 elements and so on,
     * for (n − 1) + (n − 2) + ... + 2 + 1 = n(n − 1) / 2 ∈ Θ(n2) comparisons. Each of these scans requires one swap for n − 1 elements.
     *
     * @param numbers
     */
    private static void selectionSort(int[] numbers){
        for(int i=0;i<numbers.length;i++){
            int index = i; // Taking one element
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[index]>numbers[j]){ //Comparing with each element in the array
                    swap(numbers,j,index);
                }
            }
        }
    }
    private static void swap(int[] numbers,int i, int j){
        int temp = numbers[j];
        numbers[j] = numbers[i];
        numbers[i] = temp;
    }
}
