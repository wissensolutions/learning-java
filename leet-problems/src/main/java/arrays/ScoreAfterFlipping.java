package arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/score-after-flipping-matrix/
 * @author : Wissen Solutions.
 */
public class ScoreAfterFlipping {
    @Test
    public void testHealthy() {
        Assert.assertEquals(39, matrixScore(new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}}));
    }

    public int matrixScore(int[][] A) {
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<A.length; i++){
            if(A[i][0] == 0){
                // Flip row
                for(int j=0; j<A[i].length;j++){
                    A[i][j]  = A[i][j] == 1? 0: 1;

                }
            }
        }



        for(int i=1;i<A[0].length; i++){
            int countOfOnes=0, countOfZeros = 0;
            for(int j=0; j<A.length;j++){
                if(A[j][i] == 1){
                    countOfOnes++;
                } else {
                    countOfZeros++;
                }

            }
            if(countOfOnes > countOfZeros){
                // NO change
            } else {
                // Flip column
                for(int j=0; j<A.length;j++){
                    A[j][i]  = A[j][i] == 1? 0: 1;

                }
            }


        }
        int sum = getSum(A);
        maxSum = maxSum < sum ? sum : maxSum;

        return maxSum;
        // Count number of ones in a column level
    }

    private int getSum(int[][] A){
        int sum = 0;
        for(int i=0;i<A.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<A[i].length;j++){
                sb.append(A[i][j]);
            }
            sum += Integer.parseInt(sb.toString(), 2);
        }
        return sum;
    }
}
