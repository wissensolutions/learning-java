package math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * math.FindingExcelTitleToNumber
 * Learning
 /**
 * <br> Problem Statement :
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * AAA -> 703
 *
 * </br>
 * @author WissenSolutions.
 */
public class FindingExcelTitleToNumber {
    private static final Logger logger = LoggerFactory.getLogger(FindingExcelTitleToNumber.class);

    public static void main(String[] args) {
        System.out.println(findExcelTitleNumber("A"));
        System.out.println(findExcelTitleNumber("Z"));
        System.out.println(findExcelTitleNumber("AB"));
        System.out.println(findExcelTitleNumber("AAA"));
        System.out.println(findExcelTitleNumber("AAA"));
    }

    private static int findExcelTitleNumber(String word){
        char[] chars = word.toCharArray();
        int result = 0;
        for(int i=0; i< chars.length; i++){
            result  = result * 26 + chars[i]- 'A' + 1;
        }
        return  result;
    }
}
