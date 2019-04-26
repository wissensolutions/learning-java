package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Wissen Solutions.
 */
public class PalindromeCount {
    @Test
    public void testHealthy() {
        Assert.assertEquals(7, substrCount(5,"aasasd"));
    }
    static class Point{
        char text ;
        long counter;
        Point(char t, long c){
            this.text = t;
            this.counter = c;
        }
    }
    static long substrCount(int n, String s) {
        long palindromeCount = 0L;
        long equalCounter = 1L;
        List<Point> countList = new ArrayList<>();

        for(int i=1; i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                equalCounter++;
            }
            else{
                countList.add(new Point(s.charAt(i-1),equalCounter));
                equalCounter = 1L;
            }
        }
        countList.add(new Point(s.charAt(s.length()-1), equalCounter));

        for(int i=0; i<countList.size(); i++){
            palindromeCount += (countList.get(i).counter+1)*countList.get(i).counter/2;
        }
        for (int i = 1; i < countList.size()-1; i++) {
            if(countList.get(i).counter == 1
                    && countList.get(i-1).text == countList.get(i+1).text){
                palindromeCount += Math.min(countList.get(i-1).counter,countList.get(i+1).counter);
            }
        }

        return palindromeCount;
    }

}
