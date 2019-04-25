package math;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * math.PowImplementation
 * Learning
 *
 * @author WissenSolutions.
 */
public class PowImplementation {
    private static final Logger logger = LoggerFactory.getLogger(PowImplementation.class);


    private int findPower(int number, int power){
        if (power <= 1){
            return number;
        }
        if (power % 2 == 0 ){
            number =  number * number;
            power = power/2;
            return findPower(number, power);
        } else {
            power = power - 1;
            return number * findPower( number, power);
        }
    }

//    private int findPowerWithLoop(int number, int power){
//        if (power <= 1){
//            return number;
//        }
//
//        int sum = 1;
//        while(power > 1){
//            if (power % 2 != 0 ){
//                sum =  number * sum;
//                power = power - 1;
//            } else  if(power % 2 == 0) {
//                sum *= number * number;
//                power = power / 2;
//                number = sum;
//            }
//        }
//        return sum;
//    }

    @Test
    public void testHealthy(){

        Assert.assertEquals(32, findPower(2,5));
//        Assert.assertEquals(32, findPowerWithLoop(2,5));
    }
}
