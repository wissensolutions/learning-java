package list;

import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class OddEvenLinkedList {
    @Test
    public void testHealthy() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode l2 = oddEvenList(l1);
        while(l2 != null){
            System.out.println(l2.val);
            l2 = l2.next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        int nodeIndex = 1;
        ListNode odd = head;
        ListNode oddHead = odd;
        ListNode node = head.next;
        nodeIndex++;
        ListNode even = node;
        ListNode evenHead = even;
        nodeIndex++;
        node = node.next;
        while( node != null){
            if(nodeIndex % 2 == 0){
                even.next = node;
                even = even.next;
            } else {
                odd.next = node;
                odd = odd.next;
            }
            nodeIndex++;
            node = node.next;
        }
        even.next = null;
        odd.next = evenHead;
        return oddHead;
    }

}
