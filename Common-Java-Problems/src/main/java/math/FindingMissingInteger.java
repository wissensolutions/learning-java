package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * math.FindingMissingInteger
 * Learning
 *
 * @author WissenSolutions.
 */
public class FindingMissingInteger {
    private static final Logger logger = LoggerFactory.getLogger(FindingMissingInteger.class);

    public static void main(String[] args) {
        int[] array2 = {0,1,2,3,4,5,6};
        System.out.println(findMissingInteger_withSortedArray(array2));
    }

    private static int findMissingInteger_withSortedArray(int[] sortedArray){
        int n = sortedArray.length;
        int expectedSum = n * (n+1)/2;
        int actualSum = 0;
        for(int i=0;i<n;i++){
            actualSum = actualSum + sortedArray[i];
        }
        return expectedSum - actualSum;
    }

    //TODO need to write for unsorted array
}
