package math;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : Wissen Solutions.
 */
public class RomanToInteger {
    @Test
    public void testHealthy() {
       // Assert.assertEquals(3,romanToInt("III"));
        Assert.assertEquals(1994,romanToInt("MCMXCIV"));
        Assert.assertEquals(4,romanToInt("IV"));
        Assert.assertEquals(9,romanToInt("IX"));
        Assert.assertEquals(58,romanToInt("LVIII"));

    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] array = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for(String word: words){
            StringBuilder sb = new StringBuilder();
            char[] charArr = word.toCharArray();
            for(int i=0; i<charArr.length; i++){
                sb.append(array[charArr[i]-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int result = 0;
        char[] charArr = s.toCharArray();
        for(int i=0; i<charArr.length;i++){
            int element1 = map.get(String.valueOf(charArr[i]));
            int element2 = (i+1)<charArr.length ?map.get(String.valueOf(charArr[i+1])) :0;
            if(element1<element2){
                result += element2 - element1;
                map.put(String.valueOf(charArr[i]+charArr[i+1]),element2 - element1 );
                i++;
            } else {
                result += element1;
            }
        }
        return result;
    }

//    public int romanToInt(String s) {
//        int res = 0;
//        for(int i = s.length() - 1; i >= 0; i --){
//            char c = s.charAt(i);
//            switch(c){
//                case 'I':
//                    res += res >= 5? -1 : 1; break;
//                case 'V':
//                    res += 5;break;
//                case 'X':
//                    res += res >= 50? -10 : 10; break;
//                case 'L':
//                    res += 50; break;
//                case 'C':
//                    res += res >= 500? -100 : 100; break;
//                case 'D':
//                    res += 500; break;
//                case 'M':
//                    res += 1000; break;
//
//            }
//        }
//
//        return res;
//    }
}
