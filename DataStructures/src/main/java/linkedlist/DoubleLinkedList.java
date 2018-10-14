package linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of Singly linked list
 *
 * <br> Operations supported are :
 * - Inserting a element in the list - This can be at beginning, at end or at a given position.
 * - Traversing through linked list.
 * - Check the size of the list.
 * - Check if list is empty.
 * - Search an element by index.
 * - Search an element by value.
 * - Delete an element from the list - This can again be at beginning, at end or at given position.
 * - Converting a Array from linked list.
 * </br>
 *
 * @author WissenSolutions.
 *
 * @param <T>
 */
public class DoubleLinkedList<T> {
    private static final Logger logger = LoggerFactory.getLogger(DoubleLinkedList.class);
    private Node<T> headNode;
    private Node<T> tailNode;

    private int size = 0;
    /**
     * Check first whether head node is empty
     * if its empty,then add the element to headNode directly
     * else add element in the ending
     * @param element
     */
    public void add(T element){
        Node<T> newNode = new Node<>(element);
        if(headNode == null){
            headNode = newNode;
            tailNode = newNode;
        } else {
            Node<T> tempNode = tailNode;
            tempNode.nextNode = newNode;
            tailNode = newNode;
            tailNode.previousNode = tempNode;
        }
        size++;
    }

    public void addAtSpecificPosition(T element, int iPosition){
        Node<T> newNode = new Node<>(element);
        if(headNode == null){
            headNode = newNode;
            tailNode = newNode;
        } else if (size == iPosition){
            Node<T> tempNode = tailNode;
            tempNode.nextNode = newNode;
            tailNode = newNode;
        } else {
            Node<T> tempNode = headNode;
            Node<T> previousNode  = null;
            int iterationCount = 0;
            while(iPosition > iterationCount){
                previousNode = tempNode;
                tempNode = tempNode.nextNode;
                iterationCount++;
            }
            newNode.previousNode =  tempNode.previousNode;
            newNode.nextNode = tempNode;
            previousNode.nextNode = newNode;
        }
        size++;
    }

    public void traverse(){
        Node<T> tNode = headNode;
        while(tNode != null){
            logger.info("Data={}"+tNode.nodeData);
            tNode = tNode.nextNode;
        }
    }

    public void traverseFromReverse(){
        Node<T> tNode = headNode;
        while(tNode != null){
            logger.info("Data={}"+tNode.nodeData);
            tNode = tNode.nextNode;
        }
    }

    public int getSize(){
        return size;
    }

    public T searchElementByIndex(int iRequiredIndex){
        Node<T> tNode = headNode;
        int traversedIndex = 0;
        T returnElement = null;
        if(iRequiredIndex == size){
            return tailNode.nodeData;
        }
        while(tNode != null){
            if(iRequiredIndex == traversedIndex){
                returnElement = tNode.nodeData;
                break;
            }
            traversedIndex++;
            tNode = tNode.nextNode;
        }
        return returnElement;
    }

    public Node<T> searchElementByValue(T searchValue){
        Node<T> tNode = headNode;
        if(tailNode.nodeData.equals(searchValue)){
            return tailNode;
        }

        while(tNode != null){
            if(tNode.nodeData.equals(searchValue)){
                break;
            }
            tNode = tNode.nextNode;
        }
        return tNode;
    }
    public void remove(T element){
        if(headNode == null){
            return;
        } else {
            Node<T> currentNode = headNode;
            if(headNode.nodeData.equals(element)){
                headNode = headNode.nextNode;

            }  else {
                //iterating each node and assign last node
                while(currentNode != null){
                    if(currentNode.nodeData.equals(element)){
                        if(currentNode.previousNode != null) {
                            if(currentNode.nextNode != null) {
                                currentNode.previousNode.nextNode = currentNode.nextNode;
                                currentNode.nextNode.previousNode= currentNode.previousNode;
                            } else {
                                //This will be last element
                                currentNode.previousNode.nextNode = null;
                            }
                        }
                        break;
                    }
                    currentNode = currentNode.nextNode;
                }

            }


        }
        size--;
    }

    public Object[] toArray(){
        Object[] elementsArray =  new Object[size];
        Node<T> tNode = headNode;
        for(int i=0;i<size;i++){
            elementsArray[i] = tNode.nodeData;
            if(tNode.nextNode!=null) {
                tNode = tNode.nextNode;
            }
        }
        return elementsArray;
    }
    /**
     * Node class of a linked list
     * This is needed since entire linked list is a collection
     * of nodes connected to each other through links
     *
     * <br> We are keeping it generic so that it can be used with
     * Integer, String or something else </br>
     *
     * <br> Each node contains a data item and pointer to next node.
     * Since this is a Singly linked list and each node points in
     * one direction, we maintain only pointer to one (next) node </br>
     *
     *
     * @param <T>
     */
    public class Node<T> {
        private final T nodeData;
        private  Node<T> nextNode;
        private  Node<T> previousNode;

        public Node(T iNodeData) {
            nodeData = iNodeData;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

}
