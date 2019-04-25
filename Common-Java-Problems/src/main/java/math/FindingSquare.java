package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * math.FindingSquare
 * Learning
 * <br> Problem Statement :
 *
 * Given a number n, find the square without using * operator
 *
 * </br>
 * @author WissenSolutions.
 */
public class FindingSquare {
    private static final Logger logger = LoggerFactory.getLogger(FindingSquare.class);

    public static void main(String[] args) {
        logger.info("Square for number {} = {}", 5, findSquare(5));

        logger.info("Square for number {} = {}", 4, findSquareWithoutIterator(4));
    }

    private static int findSquare(int n){
        int sum = 0;
        int iterator = 1;
        for(int i = 1; i <= n; i++){
            sum = sum + iterator;
            iterator = iterator+2;
        }
        return sum;
    }

    private static int findSquareWithoutIterator(int n){
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum = sum + n;
        }
        return sum;
    }
}
