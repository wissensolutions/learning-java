package java8;

import org.junit.Test;

import java.util.List;

/**
 * @author : Wissen Solutions.
 */
public class StreamPractice {
    @Test
    public void testHealthy() {

    }
    static void bonAppetit(List<Integer> bill, int k, int b) {

        int sum = bill.stream().mapToInt(Integer::intValue).sum();
        int notContributedItemSteak = bill.get(k)/2;
        int totalSumAnnaToBePaid = sum - notContributedItemSteak;
        if(totalSumAnnaToBePaid == b){
            System.out.println("Bon Appetit");
        } else {
            System.out.println(totalSumAnnaToBePaid - b);
        }
    }
}
