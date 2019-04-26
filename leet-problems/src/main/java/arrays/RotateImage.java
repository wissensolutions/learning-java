package arrays;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Wissen Solutions.
 */
public class RotateImage {
    @Test
    public void testHealthy() {
        int[][] matrix = new int[][]{{1,4,7},{2,5,8},{3,6,9}};
        rotate(matrix);
        System.out.println(Arrays.toString(matrix));
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            int cnt = 0;
            while (cnt < n - 1-(i*2)) {
                int leftTop = matrix[i][i];
                moveUp(matrix, n, i);
                moveLeft(matrix, n, i, n - i - 1);
                moveDown(matrix, n, n - i - 1);
                moveRight(matrix, n, n - i - 1, i);
                matrix[i][i + 1] = leftTop;
                cnt++;
            }
        }
    }

    private void moveUp(int[][] matrix, int n, int k) {
        for (int i = k; i < n - k - 1; i++) {
            matrix[i][k] = matrix[i + 1][k];
        }

    }

    private void moveDown(int[][] matrix, int n, int k) {
        for (int i = k; i > n - 1 - k; i--) {
            matrix[i][k] = matrix[i - 1][k];
        }
    }

    private void moveLeft(int[][] matrix, int n, int start, int row) {
        for (int i = start; i < n - start - 1; i++) {
            matrix[row][i] = matrix[row][i + 1];
        }
    }

    private void moveRight(int[][] matrix, int n, int start, int row) {
        for (int i = start; i > n - 1 - start; i--) {
            matrix[row][i] = matrix[row][i - 1];
        }
    }
}
