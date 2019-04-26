package arrays;

import org.junit.Test;


/**
 * https://medium.com/@ssaurel/build-a-sudoku-solver-in-java-part-1-c308bd511481
 * @author : Wissen Solutions.
 */
public class SudokuSolver {
    private int[][] board = new int[9][9];
    @Test
    public void testHealthy() {
        solve();
        print();
    }

    private void print(){
        for(int i=0; i< board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" "+ board[i][j]);
            }
            System.out.print("\n ");
        }
    }
    private boolean solve(){
        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[i].length; j++) {
                if (board[i][j] == 0) {
                    for (int k=1; k<=9; k++){
                        if(isValidNumber( k, i, j)){
                            board[i][j] = k;
                            // Check for back tracking
                            if(solve()){
                                return true;
                            } else {
                                board[i][j] = 0; // back to previous value
                            }
                        }

                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isPresentInCol( int number, int col){
        for(int i=0; i< board.length; i++){
            if(board[i][col] == number){
                return true;
            }
        }
        return false;
    }

    private boolean isPresentInRow( int number, int row){
        for(int i=0; i< board[row].length; i++){
            if(board[row][i] == number){
                return true;
            }
        }
        return false;
    }

    private boolean isPresentInSquare( int number, int row, int col){
        int r= row - row %3;
        int c= col - col %3;
        for(int i=r; i< r+3; i++){
            for(int j=c; j< c+3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isValidNumber( int number, int row, int col){
        if( !isPresentInRow( number, row) && !isPresentInCol( number, col)
                && !isPresentInSquare( number, row, col)){
            return true;
        }
        return false;
    }

}
