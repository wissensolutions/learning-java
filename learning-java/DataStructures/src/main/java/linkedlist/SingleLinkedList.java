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
public class SingleLinkedList<T> {
    private static final Logger logger = LoggerFactory.getLogger(SingleLinkedList.class);
    private Node<T> headNode;

    private int size = 0;
    /**
     * Check first whether head node is empty
     * if its empty,then add the element to headNode directly
     * else add element in the ending
     * @param element
     */
    public void add(T element){
        if(headNode == null){
            headNode = new Node<>(element);
        } else {
            Node<T> tempNode = headNode;
            //iterating each node and assign last node
            while(tempNode.nextNode != null){
                tempNode = tempNode.nextNode;
            }
            tempNode.nextNode = new Node<>(element);
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

    public int getSize(){
        return size;
    }

    public T searchElementByIndex(int iRequiredIndex){
        Node<T> tNode = headNode;
        int traversedIndex = 0;
        T returnElement = null;
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
        T returnElement = null;
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
            Node<T> previousNode = null;
            if(headNode.nodeData.equals(element)){
                headNode = headNode.nextNode;
                return;
            } else {
                //iterating each node and assign last node
                while(currentNode != null){
                    if(currentNode.nodeData.equals(element)){
                        previousNode.nextNode = currentNode.nextNode;
                        break;
                    }
                    previousNode = currentNode;
                    currentNode = currentNode.nextNode;
                }

            }


        }
        size--;
    }

    public Object[] toArray(){
        Object[] elementsArray =  new Object[size];
        Node<T> tNode = headNode;
        int index = 0;
        while (tNode.nextNode != null){
            elementsArray[index] = tNode.nodeData;
            tNode = tNode.nextNode;
        }
        //Covering final element
        elementsArray[index] = tNode.nodeData;
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

        public Node(T iNodeData) {
            nodeData = iNodeData;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> iNextNode) {
            nextNode = iNextNode;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

}
