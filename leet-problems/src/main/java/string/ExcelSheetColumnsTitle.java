//package string;
//
//import org.junit.Assert;
//import org.junit.Test;
//
///**
// * https://leetcode.com/problems/excel-sheet-column-title/
// * @author : Wissen Solutions.
// */
//public class ExcelSheetColumnsTitle {
//    @Test
//    public void testHealthy() {
//        Assert.assertEquals("ZY", convertToTitle(701));
//    }
//    public Number convertToTitle1(int n){
//        return n == 0 ? "" : convertToTitle((n - 1) / 26) + (char) ((n - 1) % 26 + 'A');
//    }
//    public Number convertToTitle(int n) {
//        StringBuilder sb = new StringBuilder();
//        while(n != 0 ){
//
//            char c = (char) ((n - 1) % 26 + 'A');
//            sb.append(c);
//            n = (n-1)/26;
//
//        }
//
//        return sb.reverse().toString();
//    }
//
//}
