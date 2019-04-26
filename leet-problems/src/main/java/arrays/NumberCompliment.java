package arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class NumberCompliment {
    @Test
    public void testHealthy() {
        Assert.assertEquals(2,findComplement(5));
    }

    public int findComplement(int num) {
        String s1 = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for(char c: s1.toCharArray()){
            if(c == '1'){
                sb.append(0);
            } else {
                sb.append(1);
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }

}
