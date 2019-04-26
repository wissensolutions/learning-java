package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author : Wissen Solutions.
 */
public class BalancedBrackets {
    @Test
    public void testHealthy() {
        Assert.assertEquals("NO",isBalanced("{)[](}]}]}))}(())("));
    }

    static String isBalanced(String s) {
        if(s.length() %2 != 0){
            return "NO";
        }
        Stack<Character> stack = new Stack();
        char[] a = s.toCharArray();
        for(int i=0; i<a.length ;i++){
            if(a[i] == '{' || a[i] == '[' || a[i] == '('){
                stack.push(a[i]);
            } else {
                if(stack.isEmpty()){
                    return "NO";
                }
                Character returnChar = stack.pop();
                if(a[i] == '}' && returnChar == '{'){
                    continue;
                } else if(a[i] == ']' && returnChar == '['){
                    continue;
                } else if(a[i] == ')' && returnChar == '('){
                    continue;
                } else {
                    return "NO";
                }
            }
        }
        if(stack.size() == 0){
            return "YES";
        }
        return "NO";
    }

}
