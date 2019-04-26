package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Wissen Solutions.
 */
public class ShortDistanceToCharacter {
    @Test
    public void testHealthy() {
        int[] array= shortestToChar("helloworld",'e');
        Assert.assertEquals(Arrays.toString(new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}),Arrays.toString(array));
    }

    public int[] shortestToChar(String S, char C) {
        if (S == null) {
            return null;
        }

        int result[] = new int[S.length()];
        int initialIndex = Integer.MAX_VALUE;
        int nextIndex = S.indexOf(C);
        char[] array = S.toCharArray();
        for (int i=0; i<S.length() - 1; i++) {
            if (array[i] == C) {
                result[i] = 0;
                initialIndex = nextIndex;
                int temp = S.indexOf(C, nextIndex + 1);
                nextIndex = temp > 0 ? temp : nextIndex;
            } else {
                result[i] = Math.min(
                        Math.abs(i - initialIndex),
                        Math.abs(i - nextIndex)
                );
            }
        }

        return result;
    }

}
