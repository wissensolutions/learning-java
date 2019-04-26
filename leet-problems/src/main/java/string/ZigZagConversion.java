package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Wissen Solutions.
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"

    Write the code that will take a string and make this conversion given a number of rows:

    string convert(string s, int numRows);
    Example 1:

    Input: s = "PAYPALISHIRING", numRows = 3
    Output: "PAHNAPLSIIGYIR"
    Example 2:

    Input: s = "PAYPALISHIRING", numRows = 4
    Output: "PINALSIGYAHRPI"
    Explanation:

    P     I    N
    A   L S  I G
    Y A   H R
    P     I
 */
public class ZigZagConversion {
    @Test
    public void testHealthy() {
        Assert.assertEquals("PAHNAPLSIIGYIR", convertToZigZag("PAYPALISHIRING", 3));
        Assert.assertEquals("PINALSIGYAHRPI", convertToZigZag("PAYPALISHIRING", 4));
    }

    private String convertToZigZag(String s, int numRows){
        int rowNum = 0;
        boolean isGoingBack = false;
        StringBuilder returnSB = new StringBuilder();
        Map<Integer, StringBuilder> map = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            char currentChar = s.charAt(i);
            map.compute(rowNum, (k,v)->{
                if(v == null){
                    v = new StringBuilder();
                }
                v.append(currentChar);
                return v;
            });

            if (isGoingBack) {
                rowNum--;
            } else {
                rowNum++;
            }
            if( rowNum == numRows -1 || rowNum == 0){
                isGoingBack = !isGoingBack;
            }

        }
        map.forEach((k,v) -> returnSB.append(v));
        return returnSB.toString();
    }



}
