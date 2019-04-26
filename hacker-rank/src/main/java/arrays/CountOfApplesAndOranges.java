package arrays;

import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class CountOfApplesAndOranges {
    @Test
    public void testHealthy() {
        countApplesAndOranges(7, 11, 5, 15, new int[]{-2,2,1}, new int[]{5, -6});
    }

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int appleCount = 0, orangeCount = 0;
        for(int i=0; i<apples.length; i++){
            int sum = apples[i]+a;
            if(sum>s && sum<t){
                appleCount++;
            }
        }

        for(int i=0; i<oranges.length; i++){
            int sum = oranges[i]+b;
            if(sum>s && sum<t){
                orangeCount++;
            }
        }
        System.out.println(appleCount);
        System.out.println(orangeCount);
    }

}
