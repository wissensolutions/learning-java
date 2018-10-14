package bag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * BagImplementationWithLinkedList
 * Learning
 *
 * @author WissenSolutions.
 */
public class BagImplementationWithLinkedList<T> implements Bag<T>{
    private static final Logger logger = LoggerFactory.getLogger(BagImplementationWithLinkedList.class);

    private Node<T> root;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 1. First check whether root element is empty, then add it as root elemenet
     * 2. If the root element is not null, then append by updating reference details in next node
     *
     * @param item
     * @return
     */
    @Override
    public boolean add(T item) {
        boolean returnValue = false;
        Node<T> newNode = new Node<>(item,null);
        if(root == null){
            root = newNode;
            returnValue = true;
            size++;
        } else {
            boolean found = false;
            //traverse till end
            Node<T> currentNode = root;
            while(currentNode.nextNode!= null){
                if(currentNode.data.equals(item)){
                    currentNode.incrementCount();
                    returnValue = true;
                    found = true;
                    break;
                } else {
                    currentNode = currentNode.nextNode;
                }
            }
            if(!found) {
                currentNode.nextNode = newNode;
                returnValue = true;
                size++;
            }
        }
        return returnValue;
    }

    @Override
    public boolean addAll(List<T> items) {
        boolean returnValue = false;
        for (T item : items) {
            returnValue = add(item); //TODO need to check whether to break the loop if one item was not added to list
        }
        return returnValue;
    }

    @Override
    public boolean remove(T item) {
        boolean isRemoved = false;

        //traverse till end
        Node<T> currentNode = root;
        Node<T> previousNode = root;
        while(currentNode.nextNode!= null){
            if(currentNode.data.equals(item)){
                //Check if the quantity is more than 1, then just decrement the value
                if(currentNode.count > 1) {
                    currentNode.decrementCount();

                } else {
                    previousNode.nextNode = currentNode.nextNode;
                }
                isRemoved = true;
                break;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.nextNode;
            }
        }
        size--;

        return isRemoved;
    }

    /**
     * 1. Just clear root element which in-turn lost reference to all other elements
     * @return
     */
    @Override
    public boolean clear() {
         root = null;
         size = 0;
         return true;
    }

    @Override
    public int size() {
        int returnValue = 0;
        Node<T> currentNode = root;
        while(currentNode.nextNode != null){
            returnValue += currentNode.count;
            currentNode = currentNode.nextNode;
        }
        if(currentNode.nextNode == null){
            returnValue += currentNode.count;
        }
        return returnValue;
    }

    @Override
    public int distinctSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> currentNode = root;
        while(currentNode.nextNode != null){
            sb.append("{").append(currentNode.data).append("}");
            currentNode = currentNode.nextNode;
        }
        if(currentNode.nextNode == null){
            sb.append("{").append(currentNode.data).append("}");
        }
        return sb.toString();
    }

    class Node<T> {
        private T data;
        private Node<T> nextNode;
        private int count;

        public Node(T iData, Node<T> iNextNode) {
            data = iData;
            nextNode = iNextNode;
            count = 1;
        }

        public void incrementCount(){
            count++;
        }

        public void decrementCount(){
            count--;
        }


    }
}
