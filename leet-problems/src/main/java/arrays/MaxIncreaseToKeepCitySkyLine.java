package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/
 * @author : Wissen Solutions.
 */
public class MaxIncreaseToKeepCitySkyLine {
    @Test
    public void testHealthy() {
        int[][] arr = new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        Assert.assertEquals(32,maxIncreaseKeepingSkyline(arr));
    }
    private Map<Integer,Integer> map = new HashMap<>();
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int sum = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                sum += Math.min(getRowMax(grid, i,j), getColMax(grid, i, j));
            }
        }
        return sum;
    }
    private int getRowMax(int[][] grid, int row, int col){
        int max = Integer.MIN_VALUE;
        for(int j = 0; j<grid[col].length; j++){
            if(grid[col][j] > max){
                max = grid[col][j];
            }
        }
        return max;
    }
    private int getColMax(int[][] grid, int row, int col){
        if(map.containsKey(row)){
            return map.get(row);
        }
        int max = Integer.MIN_VALUE;
        for(int j = 0; j<grid[0].length; j++){
            if(grid[j][row] > max){
                max = grid[j][row];
            }
        }
        map.put(row, max);
        return max;
    }
}
