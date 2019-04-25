package linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;

import java.util.LinkedList;
import java.util.Set;

/**
 * Problem01
 * <br> Problem Statement:
 *
 * Write code to remove duplicates from unsorted linked list
 *
 * FOLLOW UP : How would you solve this problem
 * if temporary buffer is not allowed.
 *
 * </br>
 *
 * @author WissenSolutions.
 */
public class Problem01 {
    private static final Logger logger = LoggerFactory.getLogger(Problem01.class);

    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Test");
        names.add("Test1");
        names.add("Test2");
        names.add("Test1");
        names.add("Test");
        logger.info("Remove Duplicates"+removeDuplicates(names));
    }

    private static <T> LinkedList<T> removeDuplicates(LinkedList<T> iLinkedList){
        Set<T> dataSet = new HashSet<>();
        int i=0;
        while(i<iLinkedList.size()){
            T dataElement = iLinkedList.get(i);
            if(dataSet.contains(dataElement)){
                iLinkedList.remove(dataElement);

            } else {
                dataSet.add(dataElement);
                i++;
            }
        }

        return iLinkedList;
    }
}
