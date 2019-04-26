package arrays;

import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class Test1 {
    @Test
    public void testHealthy() {
        try {
            String s1 = "TESTING";
            System.out.println(s1.replace('T','M'));
        } catch (Exception e) {
            System.out.println("EXce");
        }
        System.out.println("No exception");
    }

    int var1 = (int) 2.2;
    double b = 12.5;
    void display(){
        System.out.println(var1+" "+ b);
    }

}
