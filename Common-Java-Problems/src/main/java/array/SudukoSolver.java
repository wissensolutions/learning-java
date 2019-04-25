package array;

import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class SudukoSolver {
    @Test
    public void testHealthy() {
        SudukoSolver solver = new SudukoSolver(9);
        solver.solve();
        solver.displaySudoku();
    }
    private int[][] arr;
    private int length;
    private static final int UNASSIGNED = 0;

    public SudukoSolver() {
    }

    private SudukoSolver(int n){
        length = n;
        arr = new int[n][n];
    }
    // this is recursive approach
    public boolean solve(){
        // Take row and column..
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                // means this cell is empty
                if(arr[i][j] == 0){
                    for(int k=1; k<=length; k++){
                        if(isValidNum(k, i, j) ){
                            arr[i][j] = k;
                            if(solve()){
                                return true;
                            } else{
                                // Emtpy the row
                                arr[i][j] = 0;
                            }
                        }
                    }
                    // Couldn't get number with in the iteration. So returning false to back track previously assigned cell
                    return false;
                }
            }
        }
        // Once the iteration is done, then it will be like suduko is solved
        return true;
    }


    public void displaySudoku()
    {
        for(int i=0;i<9;i++)
        {
            if(i%3==0 )
            {
                System.out.println("----------------------------------\n");
            }
            for(int j=0;j<9;j++)
            {
                if(j%3==0 && j!=0)
                {
                    System.out.print(" | ");
                }
                System.out.print(" " + arr[i][j] + " ");

            }

            System.out.println();
        }
        System.out.println("\n\n__________________________________________\n\n");
    }

    private boolean isValidNum(int num, int row, int col){
        if(containsInRow(row,num) || containsInColumn(col, num) || containsInBox(row, col, num)){
            return false;
        }
        return true;
    }
    /**
     * Checks whether particular number exist in row
     */
    private boolean containsInRow(int row, int num){
        for(int i = 0; i<9; i++){
            if(arr[row][i] == num){
                return true;
            }
        }
        return false;
    }
    /**
     * Checks whether particular number exist in column
     */
    private boolean containsInColumn(int col, int num){
        for(int i = 0; i<9; i++){
            if(arr[i][col] == num){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether particular number exist in column
     */
    private boolean containsInBox(int row,  int col, int num){
        int r = row - row%3;
        int c = col - col%3;
        for(int i=row; i<r+3;i++){
            for(int j=col; j<c+3;j++){
                if(arr[i][j] == num){
                    return true;
                }
            }
        }
        return false;
    }
}
