package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FindingValidParenthesis
 * Learning
 * <br> Problem Statement :
 *
 * Given a set of parenthesis of different types
 * find if they are valid combination
 *
 * </br>
 * @author WissenSolutions.
 */
public class FindingValidExpression {
    private static final Logger logger = LoggerFactory.getLogger(FindingValidExpression.class);

    public static void main(String[] args) {
        System.out.println(isValidExpression("}}}{{{"));
        System.out.println(isValidExpression("{[]"));
        System.out.println(isValidExpression("{[()]}"));
    }
    private static boolean isValidExpression(String star){
        char[] chars = star.toCharArray();
        int parethesis = 0, braces = 0, squareBracket = 0;
        for(int i = 0; i< chars.length; i++){
            switch (chars[i]) {
                case '{' : braces++;
                            break;
                case '}' : braces--; break;
                case '(' : parethesis++; break;
                case ')' : parethesis--; break;
                case '[' : squareBracket++; break;
                case ']' : squareBracket--; break;
            }
        }
        if( parethesis == 0 && braces == 0 && squareBracket == 0){
            return true;
        }
        return false;
    }

}
