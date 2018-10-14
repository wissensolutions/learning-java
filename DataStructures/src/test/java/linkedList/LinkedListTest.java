package linkedList;


import linkedlist.SingleLinkedList;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LinkedListTest
 * Learning
 *
 * @author WissenSolutions.
 */
public class LinkedListTest {
    private static final Logger logger = LoggerFactory.getLogger(LinkedListTest.class);

    @Test
    public void testAdd(){
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        linkedList.add("Test1");
        linkedList.add("Test2");
        linkedList.add("Test3");
        linkedList.add("Test4");

        linkedList.traverse();

        linkedList.remove("Test3");

        linkedList.traverse();

        linkedList.remove("Test1");
        linkedList.traverse();
        linkedList.remove("Test4");
        linkedList.traverse();
    }
}
