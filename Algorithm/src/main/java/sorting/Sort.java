/**
 * @author WissenSolutions.
 */
package sorting;


import org.junit.Assert;
import org.junit.Test;

public abstract class Sort {
    protected static int[] inputArr = {5,3,6,1,8,7,2,4};
    protected static int[] expectedSortedArray = {1,2,3,4,5,6,7,8};

    abstract int[] doSort(int[] inputArr);

    @Test
    public void test(){
        int[] output = doSort(inputArr);
        Assert.assertArrayEquals(expectedSortedArray,output);
    }
}
