package list;

import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class ReverseDoubleLinkedList {
    @Test
    public void testHealthy() {
        DoublyLinkedListNode head = sortedInsert(null,1);
        head = sortedInsert(head,2);
        head = sortedInsert(head,3);
        head = sortedInsert(head,4);
        head = reverse(head);
        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if(head == null ){
            head = newNode;
        } else {
            DoublyLinkedListNode node = head;
            while( node != null){
                if(node.data == data){
                    break;
                } else if(node.data > data){
                    // New one will be the head
                    newNode.next = node;
                    node.prev = newNode;
                    head = newNode;
                    break;
                } else {
                    if(node.next != null && node.next.data >= data){
                        // in between
                        newNode.next = node.next;
                        newNode.prev = node.next.prev;
                        node.next.prev = newNode;
                        node.next = newNode;
                        break;
                    } else if(node.next == null){
                        // Will be last node
                        node.next = newNode;
                        newNode.prev = node;
                        break;
                    } else {
                        node = node.next;
                    }

                }
            }
        }
        return head;
    }

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        // if list is empty or list has only one element
        if( head == null || head.next == null){
            return head;
        }
        DoublyLinkedListNode currentNode = head;
        while(currentNode != null){
            DoublyLinkedListNode currentNodePrev = currentNode.prev;
            currentNode.prev = currentNode.next;
            currentNode.next = currentNodePrev;
            if( currentNode.prev == null){
                break;
            }
            currentNode = currentNode.prev;
        }
        return currentNode;
    }
    static class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int iData) {
            data = iData;
        }
    }

}
