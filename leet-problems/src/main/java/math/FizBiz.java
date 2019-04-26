package math;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * * <br> Problem Statement :
 *
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 * Example:
 * n = 15,
 *
 * Return : [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz]
 * @author : Wissen Solutions.
 */
public class FizBiz {
    @Test
    public void testHealthy() {
        Assert.assertEquals("[1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz]", printFizzBuzz(15).toString());
    }

    private List<String> printFizzBuzz(int n){
        List<String> list = new ArrayList<>();
        for(int i= 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                list.add("FizzBuzz");
            } else if (i % 3 ==0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }

        }
        return list;
    }
}
