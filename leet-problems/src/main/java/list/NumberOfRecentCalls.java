package list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Wissen Solutions.
 */
public class NumberOfRecentCalls {
    @Test
    public void testHealthy() {
        int[][] inputArr = new int[][]{{},{642},{1849},{4921},{5936},{5957}};
        Integer[] oArr = new Integer[inputArr.length];
        RecentCounter count = null;
        for(int i =0; i< inputArr.length; i++){

            if(i == 0){
                count = new RecentCounter();
            } else {
                oArr[i] = count.ping(inputArr[i][0]);
            }
        }
        Assert.assertEquals("[null, 1, 2, 1, 2, 3]", Arrays.toString(oArr));
    }

    class RecentCounter {
        Queue<Integer> q;
        public RecentCounter() {
            q = new LinkedList<>();
        }

        public int ping(int t) {
            q.add(t);
            while (q.peek() < t - 3000)
                q.poll();
            return q.size();
        }
    }
}
