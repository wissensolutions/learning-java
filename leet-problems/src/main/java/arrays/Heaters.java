package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/heaters/
 * @author : Wissen Solutions.
 */
public class Heaters {
    @Test
    public void testHealthy() {
       // Assert.assertEquals(1,findRadius(new int[]{1,2,3}, new int[]{2}));
        Assert.assertEquals(2,findRadius(new int[]{1,2,3,4,5,6}, new int[]{1,4}));
    }

    public int findRadius(int[] houses, int[] heaters) {
        int maxDiff= Integer.MIN_VALUE;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<heaters.length; i++){
            map.put(heaters[i], heaters[i]);
        }

        for(int i=0;i<houses.length; i++){
            int ceil =  map.ceilingKey(houses[i]) == null ? Integer.MAX_VALUE: map.ceilingKey(houses[i]);
            int floor =  map.floorKey(houses[i]) == null ? Integer.MAX_VALUE:map.floorKey(houses[i]);
            int diff = Math.min(Math.abs(ceil-houses[i]), Math.abs(floor-houses[i]));
            maxDiff = maxDiff< diff ? diff:maxDiff;
        }
        return maxDiff;

    }
}
