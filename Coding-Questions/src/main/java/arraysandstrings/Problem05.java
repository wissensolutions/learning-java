package arraysandstrings;

/**
 * Problem05
 * <br> Problem Statement :
 *
 * There are three types of edits that can be performed
 * on strings, insert a character, remove a character or
 * replace a character. Given two strings, write a function
 * to check of they are one edit (or zero edits) away.
 *
 * ex. pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 *
 * </br>
 *
 * @author WissenSolutions.
 */
public class Problem05 {

    public static void main(String[] args) {
        String s1 = "test";
        String s2 = "teste";
        String s3 = "tester";
        String s4 = "rest";
        System.out.println(isOnceClickAway(s1,s2));
        System.out.println(isOnceClickAway(s1,s4));
        System.out.println(isOnceClickAway(s1,s3));
        System.out.println(isOnceClickAway(s2,s3));
    }

    private static boolean isOnceClickAway(String s1, String s2){
        boolean returnValue = false;
        if(s1.length() == s2.length()){
            returnValue = replaceEditForEqualLengthStrings(s1,s2);
        } else {
            if(s1.length()>s2.length()) {
                returnValue = replaceEditForNonEqualLengthStrings(s1, s2);
            } else {
                returnValue = replaceEditForNonEqualLengthStrings(s2, s1);
            }
        }
        return returnValue;
    }

    private static boolean replaceEditForEqualLengthStrings(String s1,String s2){
        int nonReplaceableCharCount = 0;
        for(int i=0;i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                nonReplaceableCharCount++;
            }
        }
        if(nonReplaceableCharCount>1){
            return false;
        }
        return true;
    }

    private static boolean replaceEditForNonEqualLengthStrings(String s1,String s2){
        int nonReplaceableCharCount = 0;
        int j=0;
        int differenceLength = s1.length() - s2.length();
        if(differenceLength >=2){
            return false;
        }
        for(int i=0;i<s2.length(); i++){
            if(s1.charAt(i) != s2.charAt(j)){
                nonReplaceableCharCount++;
            }
            j++;
        }
        if(nonReplaceableCharCount>1){
            return false;
        }
        return true;
    }
}
