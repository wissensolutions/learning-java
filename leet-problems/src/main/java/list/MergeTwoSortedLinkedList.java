package list;

import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class MergeTwoSortedLinkedList {
    @Test
    public void testHealthy() {
        ListNode node1 = new ListNode(1);
        node1.next=new ListNode(2);
        node1.next.next=new ListNode(4);
        ListNode node2 = new ListNode(1);
        node2.next=new ListNode(3);
        node2.next.next=new ListNode(4);
        ListNode node3 = mergeTwoLists(node1, node2);
        System.out.println("test");
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null ){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode rhead = null;
        ListNode rnode = null;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                if(rhead == null){
                    rhead = new ListNode(l1.val);
                    rnode = rhead;
                } else {
                    rnode.next = new ListNode(l1.val);
                    rnode = rnode.next;
                }
                l1 = l1.next;
            } else {
                if(rhead == null){
                    rhead = new ListNode(l2.val);
                    rnode = rhead;
                } else {
                    rnode.next = new ListNode(l2.val);
                    rnode = rnode.next;
                }
                l2 = l2.next;
            }


        }
        while(l1 != null){
            rnode.next = new ListNode(l1.val);

            l1 = l1.next;
            rnode = rnode.next;
        }
        while(l2 != null){
            rnode.next = new ListNode(l2.val);
            rnode = rnode.next;
            l2 = l2.next;
        }
        return rhead;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
