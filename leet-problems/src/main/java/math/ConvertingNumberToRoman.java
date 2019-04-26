//package math;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author : Wissen Solutions.
// * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
//
//Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
//I can be placed before V (5) and X (10) to make 4 and 9.
//X can be placed before L (50) and C (100) to make 40 and 90.
//C can be placed before D (500) and M (1000) to make 400 and 900.
//Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
//
//Example 1:
//
//Input: 3
//Output: "III"
//Example 2:
//
//Input: 4
//Output: "IV"
//Example 3:
//
//Input: 9
//Output: "IX"
//Example 4:
//
//Input: 58
//Output: "LVIII"
//Explanation: L = 50, V = 5, III = 3.
//Example 5:
//
//Input: 1994
//Output: "MCMXCIV"
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
// */
//public class ConvertingNumberToRoman {
//    @Test
//    public void testHealthy() {
//        Assert.assertEquals(58, romanToInt("LVIII"));
//        Assert.assertEquals(1994, romanToInt("MCMXCIV"));
//        Assert.assertEquals(9, romanToInt("IX"));
//        Assert.assertEquals(4, romanToInt("IV"));
//        Assert.assertEquals(3, romanToInt("III"));
//    }
//
//    private int romanToInt(String s) {
//
//        Map<String, Integer> dictionary   = new HashMap<>();
//        dictionary.put("I",1);
//        dictionary.put("V", 5);
//        dictionary.put("X", 10);
//        dictionary.put("L", 50);
//        dictionary.put("C", 100);
//        dictionary.put("D", 500);
//        dictionary.put("M", 1000);
//        dictionary.put("CM", 900);
//        dictionary.put("CD", 400);
//        dictionary.put("XC", 90);
//        dictionary.put("XL", 40);
//        dictionary.put("IX", 9);
//        dictionary.put("IV", 4);
//        dictionary.put("I", 1);
//
//
//        long result = 0;
//        char[] chars = s.toCharArray();
//        if( chars[0] == 'M'){
//
//        }
//        for(int i=0; i<chars.length; i++){
//
//        }
//        int quotient1 = convert(num, 1000, sb, dictionary);
//        if(quotient1 >= 900){
//            quotient1 = convert(quotient1, 900, sb, dictionary);
//        }
//        quotient1 = convert(quotient1, 500, sb, dictionary);
//        if(quotient1 >= 400){
//            quotient1 = convert(quotient1, 400, sb, dictionary);
//        }
//        quotient1 = convert(quotient1, 100, sb, dictionary);
//        if(quotient1 >= 90){
//            quotient1 = convert(quotient1, 90, sb, dictionary);
//        }
//        quotient1 = convert(quotient1, 50, sb, dictionary);
//        if(quotient1 >= 40){
//            quotient1 = convert(quotient1, 40, sb, dictionary);
//        }
//        quotient1 = convert(quotient1, 10, sb, dictionary);
//        if(quotient1 >= 9){
//            quotient1 = convert(quotient1, 9, sb, dictionary);
//        }
//        quotient1 = convert(quotient1, 5, sb, dictionary);
//        if(quotient1 >= 4){
//            quotient1 = convert(quotient1, 4, sb, dictionary);
//        }
//        convert(quotient1, 1, sb, dictionary);
//        return sb.toString();
//    }
//    private int convert(int num, int divisor, StringBuilder sb, Map<Integer,String> dictionary){
//        int result = num /divisor;
//
//        for(int i=0; i< result; i++){
//            sb.append(dictionary.get(divisor));
//        }
//        return num % divisor;
//    }
//
//}
