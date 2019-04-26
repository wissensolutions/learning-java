package list;

import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class ReverseLinkedList {
    @Test
    public void testHealthy() {
        ListNode head = new ListNode(1).next=new ListNode(2).next=new ListNode(3);
        reverseList(reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        ListNode node1 = null;
        ListNode node = head;
        int count = 0;
        while(node.next != null){
            if(count == 1){
                node1 = new ListNode(node.val);
                node1.next = head;
            } else if(count > 1){
                node1= node.next;
            }
            node = node.next;
            count++;
        }
        return node1;

    }

    public class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

}
