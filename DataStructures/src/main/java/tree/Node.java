package tree;

import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;
    //Will have data only for AVLTrees
    private int height;

    public Node(T iData) {
        data = iData;
    }

    public T getData() {
        return data;
    }

    public void setData(T iData) {
        data = iData;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> iLeft) {
        left = iLeft;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> iRight) {
        right = iRight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int iHeight) {
        height = iHeight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
