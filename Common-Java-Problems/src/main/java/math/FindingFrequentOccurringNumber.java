package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * math.FindingFrequentOccurringNumber
 * Learning
 *
 * @author WissenSolutions.
 */
public class FindingFrequentOccurringNumber {
    private static final Logger logger = LoggerFactory.getLogger(FindingFrequentOccurringNumber.class);

    public static void main(String[] args) {
        int[] array = {2, 4, 4, 6, 4, 4, 7, 4, 4};
        System.out.println(findFrequentOccuranceNumber(array));
        System.out.println(findFrequentOccuranceNumberWithoutSorting(array));
    }
    /**
     * Method to find majority of element in the given array
     * Here, we can sort the array and since, majority > n/2
     * so, middle element will always be the majority element
     *
     * Time Complexity - Here sorting takes O(n log(n))
     * Space Complexity - O(1)
     *
     * @param array
     * @return {@link int}
     */
    private static int findFrequentOccuranceNumber(int[] array){
        if (array.length == 1) {
            return array[0];
        }
        Arrays.sort(array);

        return array[array.length/2];
    }

    /**
     * Method to find majority element in the given array
     * This is "Linear time Majority Vote Algorithm"
     *
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     *
     * @param array
     * @return {@link int}
     */
    private static int findFrequentOccuranceNumberWithoutSorting(int[] array){
        if (array.length == 1) {
            return array[0];
        }
        int count = 0;
        int result = array[0];

        for (int i1 : array) {
            if (i1 == result) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result = i1;
            }
        }
        return result;
    }
}
