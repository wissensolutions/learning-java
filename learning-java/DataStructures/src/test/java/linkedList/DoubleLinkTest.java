package linkedList;


import linkedlist.DoubleLinkedList;
import linkedlist.SingleLinkedList;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

/**
 * LinkedListTest
 * Learning
 *
 * @author WissenSolutions.
 */
public class DoubleLinkTest {
    private static final Logger logger = LoggerFactory.getLogger(DoubleLinkTest.class);

    @Test
    public void testAdd(){
        DoubleLinkedList<String> linkedList = new DoubleLinkedList<String>();
        linkedList.add("Test1");
        linkedList.add("Test2");
        linkedList.add("Test3");
        linkedList.add("Test4");
        linkedList.addAtSpecificPosition("Test5",2);
        linkedList.traverse();

        linkedList.remove("Test3");

        Object[] listArray = linkedList.toArray();
        Assert.assertEquals(listArray.length,4);
        Assert.assertFalse(Stream.of(listArray).anyMatch(item-> String.valueOf(item).equals("Test3")));

        linkedList.remove("Test1");
        listArray = linkedList.toArray();
        Assert.assertEquals(listArray.length,3);
        Assert.assertFalse(Stream.of(listArray).anyMatch(item-> item.equals("Test1")));

        linkedList.remove("Test4");
        listArray = linkedList.toArray();
        Assert.assertEquals(listArray.length,2);
        Assert.assertFalse(Stream.of(listArray).anyMatch(item-> item.equals("Test4")));

    }
}
