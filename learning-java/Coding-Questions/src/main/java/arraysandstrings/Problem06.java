package arraysandstrings;

/**
 * Problem05
 * <br> Problem Statement :
 *
 * Implement a method to perform basic string compression
 * using the count of repeated characters. For ex. the string
 * "aabcccccaaa" would become "a2b1c5a3". If the sum compressed string
 * does not become smaller then the original string, then your
 * method should return the original string. You can assume that
 * the string has only upper case and lower case letters.
 *
 * </br>
 *
 * @author WissenSolutions.
 */
public class Problem06 {

    public static void main(String[] args) {
        String s1 = "aabcccccaaa";
        System.out.println(compressString(s1));
    }

    private static String compressString(String s1){
        int sameCharCount = 1;
        StringBuilder sb = new StringBuilder();
        char currentChar = 0;
        for(int i=0;i<s1.length()-1;i++){
             currentChar = s1.charAt(i);

            if( currentChar == s1.charAt(i+1)){
                sameCharCount++;
            } else {
                sb.append(currentChar);
                sb.append(sameCharCount);
                //Resetting back to 1
                sameCharCount = 1;
            }

        }

        /* There is no append happening for last set of characters,
		 * because if condition won't be true. Appending them here. */
        sb.append(currentChar);
        sb.append(sameCharCount);

        if(sb.length() < s1.length()){
            return sb.toString();
        } else {
            return s1;
        }
    }


}
