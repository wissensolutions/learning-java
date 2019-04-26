package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : Wissen Solutions.
 */
public class PickingNumbers {
    @Test
    public void testHealthy() {
        //Assert.assertEquals(22,pickingNumbers(Arrays.asList(4, 2, 3, 4, 4, 9, 98, 98, 3, 3, 3, 4, 2, 98, 1, 98, 98, 1, 1, 4 ,98 ,2, 98 ,3, 9, 9, 3, 1 ,4 ,1, 98 ,9, 9, 2, 9, 4, 2, 2, 9, 98, 4, 98, 1, 3, 4 ,9, 1, 98, 98, 4, 2, 3 ,98, 98 ,1, 99, 9, 98, 98, 3, 98, 98, 4, 98, 2, 98, 4, 2 ,1, 1, 9, 2, 4)));
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<10;i++){
            list.add(66);
        }
        Assert.assertEquals(100,pickingNumbers(list));
    }

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        int minNum = -1, longestSeqLength = 0;
        int seq = 1;
        Collections.sort(a);
        for(int i=0; i< a.size(); i++){
            for(int j=i+1; j< a.size(); j++){
                if( (a.get(j)-a.get(i) <=1)){
                    seq++;
                }
            }

            if(longestSeqLength < seq){
                longestSeqLength = seq;

            }
            seq = 1;
        }

        return longestSeqLength;

    }
}
