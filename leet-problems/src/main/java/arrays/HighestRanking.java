package arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : Wissen Solutions.
 */
public class HighestRanking {
    @Test
    public void testHealthy() {
    climbingLeaderboard(new int[]{100,90, 90, 80, 75, 60}, new int[]{50, 65, 77, 90, 102});
    }

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] returnArr = new int[alice.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        AtomicInteger rank = new AtomicInteger(0);
        for(int score : scores){
            map.computeIfAbsent(score,(k)-> rank.incrementAndGet() );

        }

        for(int i = 0;i< alice.length; i++){
            int mark = alice[i];
            Map.Entry<Integer,Integer> entry = map.ceilingEntry(mark);
            if(entry == null){
                returnArr[i] =1;
                continue;
            }
            if(entry.getKey()> mark){
                returnArr[i]  = entry.getValue()+1;
            } else if(entry.getKey()< mark){
                returnArr[i]  = entry.getValue()-1;
            } else {
                returnArr[i]  = entry.getValue();
            }


        }
        System.out.println(Arrays.toString(returnArr));
        return returnArr;


    }

}
