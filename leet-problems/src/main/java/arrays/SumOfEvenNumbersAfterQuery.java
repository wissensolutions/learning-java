package arrays;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Wissen Solutions.
 */
public class SumOfEvenNumbersAfterQuery {
    @Test
    public void testHealthy() {
        int[] a = sumEvenAfterQueries(new int[]{1,2,3,4}, new int[][]{{1,0},{-3,1},{-4,0},{2,3}});
        System.out.println(Arrays.toString(a));
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int evenSum = 0;
        for(int i =0; i< A.length; i++){
            if(A[i] % 2 == 0){
                evenSum += A[i];
            }
        }
        int[] resultArr = new int[A.length];
        for(int i = 0; i<queries.length; i++){
            int athIndex = queries[i][1];
            int athVal = queries[i][0];
            if (A[athIndex] % 2 == 0) evenSum -= A[athIndex];
            A[athIndex] += athVal;
            if (A[athIndex] % 2 == 0) evenSum += A[athIndex];
            resultArr[i] = evenSum;

        }
        return resultArr;
    }

}
