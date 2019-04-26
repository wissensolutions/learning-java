package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class LibraryFine {
    @Test
    public void testHealthy() {
        Assert.assertEquals(0,libraryFine(28, 2, 2015, 15, 4, 2015));
    }

    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        if(y1 < y2 ){
            // Return with in the year
            return 0;
        } else if(y1 == y2 ) {
            // Same year. So checking for month
            if(m1 < m2) {
                return 0;
            } else if(m1 == m2){
                if(d1 > d2){
                    return (d1-d2) * 15;
                }
                return 0;
            } else {
                return (m1-m2) * 500;
            }
        } else {
            // returned 1 year later
            return 10000;
        }



    }
}
