package arrays;

import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class NewYearChaos {
    @Test
    public void testHealthy() {
        minimumBribes(new int[]{2 ,1 ,5 , 3, 4});
        minimumBribes(new int[]{1 ,2 ,5 ,3 ,7 ,8 ,6 ,4});
        minimumBribes(new int[]{1 ,2 ,5 ,3 ,7 ,8 ,6 ,9, 4});
        minimumBribes(new int[]{2, 5, 1, 3, 4});
    }

    static void minimumBribes(int[] q) {
        int moveCount = 0;

        for(int i=0; i< q.length; i++){
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, q[i]-2); j < i; j++)
                if (q[j] > q[i])
                    moveCount++;


        }
        System.out.println(moveCount);
    }

//    static void minimumBribes(int[] q) {
//        int moveCount = 0;
//        for (int i = q.length - 1; i >= 0; i--) {
//            if(q[i] != i) {
//                if (q[i] - (i + 1) > 2) {
//                    System.out.println("Too chaotic");
//                    return;
//                }
//                moveCount = moveCount + (i + 1) - q[i];
//            }
//        }
//        System.out.println(moveCount);
//    }


}
