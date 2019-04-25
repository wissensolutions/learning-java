package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * math.FindingNumberToExcelTitle
 * Learning
 * <br> Problem Statement :
 *
 * Given a column number in excel sheet, return it's column title
 * For example :
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 *
 * </br>
 * @author WissenSolutions.
 */
public class FindingNumberToExcelTitle {
    private static final Logger logger = LoggerFactory.getLogger(FindingNumberToExcelTitle.class);

    public static void main(String[] args) {
        System.out.println(findTitleForGivenNumber(25));
        System.out.println(findTitleForGivenNumber(26));
        System.out.println(findTitleForGivenNumber(27));
        System.out.println(findTitleForGivenNumber(3));
    }

    private static String findTitleForGivenNumber(int number){
        StringBuilder builder = new StringBuilder();
        while(number != 0){
            builder.append((char) ('A' + number % 26));
            number = number / 26;
        }
        return builder.toString();
    }
}
