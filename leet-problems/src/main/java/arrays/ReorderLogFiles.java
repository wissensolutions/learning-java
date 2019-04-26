//package arrays;
//
//import org.junit.Test;
//
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * https://leetcode.com/problems/reorder-log-files/submissions/
// * @author : Wissen Solutions.
// */
//public class ReorderLogFiles {
//    @Test
//    public void testHealthy() {
//        //String[] output = reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"});
//
//
//       // String[] output = reorderLogFiles(new String[]{"n 1 6","r wyv","7 72","4 95","x 706"});
//        String[] output = reorderLogFiles(new String[]{"1 n u", "r 527", "j 893", "6 14", "6 82"});
//        System.out.println(Arrays.toString(output));
//    }
//
//    public String[] reorderLogFiles(String[] logs) {
//        List<String> numberList = new LinkedList<>();
//        for(int i=1; i<logs.length; i++){
//            if(logs[i-1] == null || logs[i] == null){
//                break;
//            }
//            String[] strArr1 = logs[i-1] != null ? getStringArr(logs[i-1],i-1, logs, numberList):null;
//            String[] strArr2 = logs[i] != null ? getStringArr(logs[i],i, logs, numberList):null;
//            if(strArr1 == null || strArr2 == null){
//                continue;
//            }
//            int result = compareStrings(strArr1[1], strArr2[1]);
//            if(result ==0 ){
//                if(compareStrings(strArr1[0], strArr2[0]) ==1) {
//                    // swap elements
//                    String temp = logs[i];
//                    logs[i] = logs[i-1];
//                    logs[i-1] = temp;
//                }
//            } else if(result  == 1 ){
//                // swap elements
//                String temp = logs[i];
//                logs[i] = logs[i-1];
//                logs[i-1] = temp;
//            }
//        }
//        int emptyStringIndex = logs.length-numberList.size();
//        for(int i=0; i< numberList.size();i++){
//            logs[emptyStringIndex+i] = numberList.get(i);
//        }
//        return logs;
//    }
//    private String[] getStringArr(String log, int index, String[] logs,List<String> numberList ){
//
//        String identifier = log.substring(0,log.indexOf(' '));
//        String data = log.substring(log.indexOf(' ')+1);
//
//        if(Character.isDigit(data.charAt(0))){
//            // Swap with last element
//            int lastNonSwappedIndex = logs.length-(numberList.size());
//            if(lastNonSwappedIndex <= index) {
//                return null;
//            }
//
//            String lastNonSwappedLog = logs[lastNonSwappedIndex];
//            String lastNonSwappedIdentifier = lastNonSwappedLog.substring(0,log.indexOf(' '));
//            String lastNonSwappedData = log.substring(log.indexOf(' ')+1);
//            if((Character.isDigit(data.charAt(0))){)
//            logs[logs.length-1-(numberList.size())] = null;
//            logs[index] = lastNonSwappedLog;// replace current string with swappable string
//            numberList.add(log);// add number log to list
//            return getStringArr(swappedLog, index, logs, numberList );
//        } else {
//            return new String[]{identifier, data};
//        }
//    }
//
//    private int compareStrings(String s1, String s2){
//        char[] charArr1 = s1.toCharArray();
//        char[] charArr2 = s2.toCharArray();
//
//        if(s1.length() > s2.length()){
//            for(int i = 0; i< charArr2.length; i++){
//                if(charArr1[i] > charArr2[i]){
//                    return 1;
//                }else if(charArr1[i] < charArr2[i]){
//                    return -11;
//                }
//            }
//        } else if(s1.length() < s2.length()) {
//            for(int i = 0; i< charArr1.length; i++){
//                if(charArr1[i] > charArr2[i]){
//                    return 1;
//                } else if(charArr1[i] < charArr2[i]){
//                    return -1;
//                }
//            }
//        } else {
//            boolean isAllCharEqual = true;
//            for(int i = 0; i< charArr1.length; i++){
//                if(charArr1[i] != charArr2[i] ){
//                    isAllCharEqual = false;
//                }
//                if(charArr1[i] > charArr2[i]) {
//                    return 1;
//                }else if(charArr1[i] < charArr2[i]){
//                    return -1;
//                }
//            }
//            if(isAllCharEqual ){
//                return 0;
//            }
//
//        }
//        return -1;
//
//
//    }
//
//}
