package arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/the-hurdle-race/problem
 * @author : Wissen Solutions.
 */
public class HurdleRace {
    @Test
    public void testHealthy() {
        Assert.assertEquals(2,hurdleRace(47,new int[]{52, 99, 93, 84, 50, 64, 61, 87, 89, 97, 64, 69 ,61 ,90 ,82 ,53 ,50,
                63, 82, 87, 76, 78, 75, 55, 80, 68, 75, 83, 69, 81, 95, 89, 60, 59, 90, 100, 90, 64, 53, 60, 88,
                93, 62, 50, 75, 77, 60, 93, 55, 79, 52, 47, 65, 74, 62, 60, 96, 49, 73, 92, 79, 54, 100, 81, 63, 58,
                75, 80, 89, 94, 52, 85, 57, 72, 97, 81, 97, 66, 84, 77, 83, 94, 85, 68, 99, 54, 64, 83, 67, 84, 81, 65,
                59, 89, 68, 91, 60, 79, 74, 57
        }));
    }

    static int hurdleRace(int k, int[] height) {
        int maxElement = Integer.MIN_VALUE;
        for(int i =0; i< height.length; i++){
            if(maxElement < height[i]){
                maxElement = height[i];
            }
        }

        return maxElement - k;
    }
}
