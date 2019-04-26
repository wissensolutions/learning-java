package arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class RectangleOverlap {
    @Test
    public void testHealthy() {
        Assert.assertTrue(isRectangleOverlap(new int[]{7,8,13,15}, new int[]{10,8,12,20}));
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // 1st case R2 is overlapping with R1
        boolean xAxis1 =( (rec2[0] > rec1[0] && rec2[0] < rec1[2]) || (rec2[2] > rec1[0] && rec2[2] < rec1[2]) );

        boolean yAxis1 =( (rec2[1] > rec1[1] && rec2[1] < rec1[3]) || (rec2[3] > rec1[1] && rec2[3] < rec1[3]) );

        // 2nd case R1 is overlapping with R2
        boolean xAxis2 =( (rec1[0] > rec2[0] && rec1[0] < rec2[2]) || (rec1[2] > rec2[0] && rec1[2] < rec2[2]) );

        boolean yAxis2 =( (rec1[1] > rec2[1] && rec1[1] < rec2[3]) || (rec1[3] > rec2[1] && rec1[3] < rec2[3]) );

        return (xAxis1 || yAxis1) || (xAxis2 || yAxis2);
    }
}
