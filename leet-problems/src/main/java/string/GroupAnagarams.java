package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Wissen Solutions.
 */
public class GroupAnagarams {
    @Test
    public void testHealthy() {
        List<List<String>> list = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        Assert.assertEquals(3,list.size());
    }

//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> result = new ArrayList<>();
//        Map<String, Integer> rowMap = new HashMap<>();
//        for(String s : strs){
//            char[] chars = s.toCharArray();
//            Arrays.sort(chars);
//            String sortedString = new String(chars);
//            Integer rowCount = rowMap.get(sortedString);
//
//            List<String> list = null;
//            if(rowCount == null){
//                list = new ArrayList<>();
//                rowCount = result.size();
//                rowMap.put(sortedString, rowCount);
//                list.add(s);
//                result.add(rowCount, list);
//            } else {
//                list = result.get(rowCount);
//                list.add(s);
//            }
//
//
//
//        }
//        return result;
//    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> rowMap = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            List<String> rowList = rowMap.get(sortedString);

            if(rowList == null){
                rowList = new ArrayList<>();

                rowList.add(s);
                rowMap.put(sortedString, rowList);
                result.add( rowList);
            } else {
                rowList.add(s);
            }
        }
        return result;
    }
}
