package arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BitwiseCompliment
 * Learning
 *
 * @author WissenSolutions.
 */
public class BitwiseCompliment {
    private static final Logger logger = LoggerFactory.getLogger(BitwiseCompliment.class);

    public static void main(String[] args) {
        int i = 5;
        int j = ~i;
        logger.info("Value={}",j);
    }
}
