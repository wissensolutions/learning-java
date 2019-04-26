package arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 * John works at a clothing store. He has a large pile of socks that he must pair them by color for sale.
You will be given an array of integers representing the color of each sock. Determine how many pairs of
socks with matching colors there are.
John works at a clothing store and he's going through a pile of socks to find the number of matching pairs.
More specifically, he has a pile of loose socks where each sock is labeled with an integer, , denoting
its color. He wants to sell as many socks as possible, but his customers will only buy them in matching
pairs. Two socks, and , are a single matching pair if they have the same color ( ).
Given and the color of each sock, how many pairs of socks can John sell?
Input Format
The first line contains an integer , the number of socks.
The second line contains space-separated integers describing the colors of the socks in the pile.
Constraints
where
Output Format
Print the total number of matching pairs of socks that John can sell
 */
public class SockMarchent {
    @Test
    public void testHealthy() {
        Assert.assertEquals(3, sockMerchant(9, new int[]{10 ,20, 20, 10 ,10 ,30 ,50 ,10, 20}));
    }
    private int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        int pairIndex = Integer.MIN_VALUE;
        int pairNumber = 0;
        for(int i = 0; i<n; i++){
            pairNumber = ar[i];
            for(int j = i; j<n; j++){
                if(pairNumber != 0 && pairNumber == ar[j]){

                    if( pairIndex != Integer.MIN_VALUE) {
                        pairs++;
                        ar[j] = 0;
                        ar[pairIndex] = 0;
                        pairIndex = Integer.MIN_VALUE;
                    } else {
                        pairIndex = j;
                    }
                }
            }
            pairIndex = Integer.MIN_VALUE;
        }
        return pairs;
    }

}
