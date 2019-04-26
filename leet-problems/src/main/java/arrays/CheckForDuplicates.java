package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * * <br> Problem Statement :
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 * </br>
 * @author : Wissen Solutions.
 */
public class CheckForDuplicates {
    @Test
    public void testHealthy() {
        Assert.assertTrue(isDuplicateElementExist(new int[]{1,2,4,5,2,3}));
    }

    private boolean isDuplicateElementExist(int[] array){
        Set<Integer> set = new HashSet<>();
        for(int n: array){
            if(set.contains(n)){
                return true;
            }
            set.add(n);
        }

        return false;
    }

}
