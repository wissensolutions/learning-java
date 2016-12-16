/**
 * searching
 * <p>
 */
package searching;

/**
 * <p>Linear Search is also called Sequential Search
 * Few point to note here,
 * 1. It can be really slow with large number of elemets in the collection
 * ex. If we have 1000000 items in the list, on an average it will take 500000 number of comparisons
 * 2. To be used when we are not sure about the sort order of the list. </p>
 * <p>
 * <p>Algorithm :
 * 1. Loop through each item in the list
 * 2. Compare search term to the current item in the list
 * 3. If matches, save index of the matching item and break
 * 4. return index of matching item, or -1 if not found
 * </p>
 * <p>
 * <p>Complexity :
 * 1. Best Case : What is the fewer number of iterations to find the item?
 * => Best case is when search term is at the first slot of the array
 * => Number of comparisons in this case is 1
 * <p>
 * 2. Worst Case : What is the most number of comparisons needed to find the item?
 * => Worst case is when search term is at the last slot of the array or not at all in the array
 * => If our array is of size N, we need N comparisons for worst case
 * <p>
 * 3. Average Case : On an Average, how many comparisons are needed to find the element in the array?
 * => On an average, search term will be in the middle of the array
 * => For an array of size N, number of comparisons will be N/2
 * </p>
 */
public class LinearSearch {

    public static void main(String[] args) {
        int[] numbers = {0, 12, 34, 23, 212, 67, 89, 22};

        int index = getIndex(numbers, 89);

    }

    private static int getIndex(int[] numbers, int searchNumber) {
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == searchNumber) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Element not found in list");
        } else {
            System.out.println("Search success. Index=" + index);
        }
        return index;
    }
}
