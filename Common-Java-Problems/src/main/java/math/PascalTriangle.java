package math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Wissen Solutions.
 */
public class PascalTriangle {
    @Test
    public void testHealthy() {
        generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<numRows;i++){
            List<Integer> cellList = new ArrayList<>();
            if(i == 0 ){
                cellList.add(1);
            } else {
                List<Integer> prevList =  result.get(i-1);
                cellList.add(1);
                for(int j=0;j<prevList.size()-1;j++){
                    cellList.add(prevList.get(j)+prevList.get(j+1));
                }
                cellList.add(1);
            }
            result.add(cellList);
        }
        return result;
    }
}
