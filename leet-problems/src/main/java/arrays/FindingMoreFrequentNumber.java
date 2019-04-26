package arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * * <br> Problem Statement :
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * </br>
 *
 * @author : Wissen Solutions.
 */
public class FindingMoreFrequentNumber {
    @Test
    public void testHealthy() {
        int[] array = {2, 4, 4, 5, 4};
        Assert.assertEquals(4, findMoreFrequentNumber(array));
    }

    /**
     * Method to find majority element using moore's voting algorithm
     */
    private int findMoreFrequentNumber(int[] array){
        int count = 0;
        int frequentElement = array[0];
        for(int i=0; i<array.length; i++){
            if(count == 0){
                frequentElement = array[i];
            }
            if(frequentElement == array[i]){
                count++;
            } else {
                count--;
            }

        }
        return frequentElement;
    }

}
