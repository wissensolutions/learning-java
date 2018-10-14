package searching;

import org.junit.Assert;
import org.junit.Test;

/**
 * Search
 * Learning
 *
 * @author WissenSolutions.
 */
public abstract class Search {

    protected static int[] inputArr = {1,2,3,4,5,6,7,8};

    private static int searchElement = 8;
    abstract int doSearch(int[] inputArr, int searchElement);

    @Test
    public void test(){
        int index = doSearch(inputArr, searchElement);
        Assert.assertEquals(index,7);
    }
}
