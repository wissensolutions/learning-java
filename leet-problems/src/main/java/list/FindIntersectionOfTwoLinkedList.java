package list;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Wissen Solutions.
 */
public class FindIntersectionOfTwoLinkedList {
    @Test
    public void testHealthy() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(3);
        l1.next.next.next= new ListNode(4);
        l1.next.next.next.next= new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = l1.next;
        System.out.println(getIntersectionNode(l1,l2));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Boolean> map = new HashMap<>();
        if(headA == null || headB == null){
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(true){
            if(nodeA != null){
                if(map.containsKey(nodeA)){
                    return nodeA;
                }
                map.put(nodeA, true);
                nodeA = nodeA.next;
            }
            if(nodeB != null){
                if(map.containsKey(nodeB)){
                    return nodeB;
                }
                map.put(nodeB, true);
                nodeB = nodeB.next;
            }
            if(nodeA == null && nodeB == null){
                return null;
            }

        }

    }
}
