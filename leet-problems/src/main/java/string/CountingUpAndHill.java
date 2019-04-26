package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class CountingUpAndHill {
    @Test
    public void testHealthy() {
        Assert.assertEquals( 1,countingValleys(8, "UDDDUDUU"));
        Assert.assertEquals( 2,countingValleys(8, "DDUUDDUDUUUD"));
    }
    private int countingValleys(int n, String s) {
        int valleyCount = 0;
        int level = 0;
        for (char c: s.toCharArray()) {
            if(c == 'U' ){
                level++;
            }
            if(c == 'D' ){
                level--;
            }
            //If level is zero and ending up with up level
            if( level == 0 && c == 'U' ){
                valleyCount++;
            }
        }

        return valleyCount;
    }
}
