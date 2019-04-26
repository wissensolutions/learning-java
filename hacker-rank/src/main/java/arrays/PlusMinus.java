package arrays;

import org.junit.Test;

import java.text.DecimalFormat;

/**
 * @author : Wissen Solutions.
 */
public class PlusMinus {
    @Test
    public void testHealthy() {
        plusMinus(new int[]{-4, 3 ,-9 ,0 ,4 ,1});
    }
    static void plusMinus(int[] arr) {
        DecimalFormat df = new DecimalFormat("###.######");
        int pCount = 0, nCount = 0, zCount = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>0){
                pCount++;
            } else if(arr[i]<0){
                nCount++;
            } else {
                zCount++;
            }
        }
        double pR = (double) pCount/arr.length;
        double nR = (double) nCount/arr.length;
        double zR = (double) zCount/arr.length;
        System.out.println(pR);
        System.out.println(df.format(nR));
        System.out.println(df.format(zR));
    }
}
