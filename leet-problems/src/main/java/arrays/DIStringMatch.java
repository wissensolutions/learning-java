package arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class DIStringMatch {
    @Test
    public void testHealthy() {
        Assert.assertEquals("[0, 4, 1, 3, 2]", diStringMatch("IDID"));
    }

    public static int[] diStringMatch(String S) {
        int[] ans = new int[S.length() + 1];
        int increase = 0, decrease = S.length();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                ans[i] = increase++;
            } else {
                ans[i] = decrease--;
            }
        }
        ans[S.length()] = increase;
        return ans;
    }
}
