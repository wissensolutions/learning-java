package tree;


/**
 * Node
 * Learning
 *
 * @author WissenSolutions.
 */
public class Node<T> {
    private T value;
    private Node<T> leftNode;
    private Node<T> rightNode;

    public Node(T iValue) {
        value = iValue;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T iValue) {
        value = iValue;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<T> iLeftNode) {
        leftNode = iLeftNode;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> iRightNode) {
        rightNode = iRightNode;
    }

    @Override
    public String toString() {
        return "Node { " +
                "value = " + value +
                " }";
    }
}
