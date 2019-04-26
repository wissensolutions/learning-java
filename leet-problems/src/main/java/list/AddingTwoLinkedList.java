package list;


import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class AddingTwoLinkedList {



    @Test
    public void testHealthy() {
        String s1 = "9";
        String s2 = "1,9,9,9,9,9,9,9,9,9";


        ListNode l1 = getListNodeFromString(s1);
        ListNode l2 = getListNodeFromString(s2);
        ListNode listNode = addTwoNumbers(l1,l2);
        System.out.println(listNode);
    }

    private ListNode getListNodeFromString(String s){
        String[] array = s.split(",");
        ListNode  node = null;
        for(int i=0; i<array.length; i++){
            node = addToNode(node, Integer.parseInt(array[i]));
        }
        return node;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long list1Sum = getSum(l1);
        long list2Sum = getSum(l2);
        long sum = list1Sum + list2Sum;
        ListNode sumNode = null;
        if(sum == 0){
            return new ListNode(0);
        }
        while( sum != 0){
            int val = (int) sum % 10;
            sumNode =   addToNode(sumNode, val);
            sum = sum / 10;
        }
        return sumNode;

    }

    private ListNode addToNode(ListNode sumNode, int val){
        if( sumNode == null) {
            sumNode = new ListNode(val);
            return sumNode;
        }
        ListNode node = sumNode;
        while(node.next != null){
            node = node.next;
        }
        node.next = new ListNode(val);
        return sumNode;
    }
    private long getSum(ListNode list){
        if(list == null){
            return 0;
        } else {
            int k = 1;
            long listSum = 0;
            while(list.next != null){
                listSum += list.val * k;
                k = k * 10;
                list = list.next;
            }
            //last node
            long kk= list.val * k;
            return listSum + kk;
        }
    }
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int iVal) {
            val = iVal;
        }
    }
}
