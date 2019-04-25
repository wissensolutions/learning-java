package math;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author : Wissen Solutions.
 */
public class FindAndReplaceString {
    @Test
    public void testHealthy() {
        List<String> list = findAndReplacePattern(new String[]{"abc", "mee", "tss"}, "abb");
        Assert.assertTrue(list.size() >0);
    }

    private List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = getNumberPattern(pattern);
        List<String> res = new ArrayList<>();
        for (String w : words) {
            if (Arrays.equals(getNumberPattern(w), p)) {
                res.add(w);
            }
        }

        return res;
    }


    private int[] getNumberPattern(String w) {
        HashMap<Character, Integer> m = new HashMap<>();
        int n = w.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            m.putIfAbsent(w.charAt(i), m.size());
            res[i] = m.get(w.charAt(i));
        }
        return res;
    }
}
