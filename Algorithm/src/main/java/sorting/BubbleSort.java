/**
 * Class for Bubble Sort
 * <p>
 * Created by Amar Veerepalli
 */
package sorting;

import java.util.Arrays;

/**
 * Bubble Sort implementation
 * <p> Question - When will you consider a list of items to be sorted?
 * Answer - When all the elements to the left of each element are smaller then the element
 *
 * This algorithm works on this principle. We start this Algorithm from index = 1, because element
 * at index 0 is already considered as sorted since there are no elements on its left side.
 * In this algorithm, we pick up each item and compares it to the item positioned on its left.
 * If picked up item is smaller then the left item, then it is in wrong position.
 * We swap it and keep going on until the items are finished.</p>
 *
 * <p>How it works?
 * 1. Loop through the entire collection of elements n-1 times.
 * 	  We start with N = 1 here, as explained above (Assume first element is already sorted in the collection)
 * 2. Loop through rest of the collection again to keep comparing each of the item
 * 3. If item on the left is smaller then the item on the right, swap it
 * 4. Repeat 1-3 till we get sorted collection back</p>
 *
 * <p>Time Complexity</p>
 * Whenever there are inner loops associated, complexity is n^2. In this case,
 * Best - O(n)
 * Average - O(n^2)
 * Worst - O(n^2)
 *
 */
public class BubbleSort {

    public static void main(String[] args){
        int[] valuesToBeSorted = {7, 10, 47, 40, 83, 84, 65, 61, 32, 55, 49, 46, 25, 20, 93, 63, 54, 10};
        sortAndPrint(valuesToBeSorted);

    }
    private static void sortAndPrint(int[] numbers){
        for(int i=0;i<numbers.length;i++){
            for(int j= 1;j<numbers.length-1;j++){
                if(numbers[j]>numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        Arrays.stream(numbers).forEach(System.out::println);
    }


}
