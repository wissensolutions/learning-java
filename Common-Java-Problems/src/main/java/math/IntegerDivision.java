package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * math.IntegerDivision
 * Learning
 * <br> Problem Statement :
 *
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 *
 * </br>
 * @author WissenSolutions.
 */
public class IntegerDivision {
    private static final Logger logger = LoggerFactory.getLogger(IntegerDivision.class);

    public static void main(String[] args) {
        System.out.println(divide(234, 4));
        System.out.println(divide(234, -4));
    }

    private static int divide(int a, int b){
        int sign = (a | b) <0 ? -1: 1;
        int count = 0;
        a = Math.abs(a); // Converting all the number into absolute number
        b = Math.abs(b);
        while (a - b >= 0){
            a = a - b;
            count++;
        }
        return sign * count;
    }
}
