package arrays;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Wissen Solutions.
 */
public class MinMaxSum {
    @Test
    public void testHealthy() {
        miniMaxSum(new int[]{256741038, 623958417, 467905213, 714532089, 938071625
        });
    }
    static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);
        int minSum = 0, maxSum= 0;
        for(int i =0;i<arr.length;i++){
            if(i!=0){
                maxSum += arr[i];
            }
            if(i!=arr.length-1){
                minSum += arr[i];
            }
        }
        System.out.println(minSum+" "+maxSum);
    }

    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        if(s.indexOf("AM")>0){
            return s.substring(0,s.indexOf("AM"));
        } else {
            String s1 =  s.substring(0,s.indexOf("PM"));
            int hours = Integer.parseInt(s1.substring(0,s.indexOf(":")))+12;
            String hrs = String.valueOf(hours);
            return s1.replace(s1.substring(0,s.indexOf(":")),hrs );


        }
    }

}
