package arraysandstrings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Problem03
 * Learning
 * <p>
 * @author WissenSolutions.
 */
public class Problem03 {
    private static final Logger logger = LoggerFactory.getLogger(Problem03.class);
    public static void main(String[] args ){
        logger.info("urlIfyString={}",urlIfyString("test this"));
    }

   private static String urlIfyString(String inputString){
        StringBuilder builder = new StringBuilder();

        char[] charArray = inputString.toCharArray();
        for(int i=0; i<charArray.length; i++ ){
            if(charArray[i] == ' '){
                builder.append("%20");
            } else {
                builder.append(charArray[i]);
            }
        }
        return builder.toString();
   }
}
