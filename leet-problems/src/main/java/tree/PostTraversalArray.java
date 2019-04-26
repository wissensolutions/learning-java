package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author : Wissen Solutions.
 */
public class PostTraversalArray {
    @Test
    public void testHealthy() {
        Node node3 = new Node(3, Arrays.asList(new Node(5,null),new Node(6,null)));
        Node node = new Node(1,Arrays.asList(node3,new Node(2,null),new Node(4,null)));
        System.out.println(postorder(node));
        System.out.println(postorder_iterative(node));
    }
    public List<Integer> postorder(Node root) {
        if(root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        if(root.children != null){
            for (int i = 0; i < root.children.size(); i++) {
                list.addAll(postorder(root.children.get(i)));
            }
        }
        list.add(root.val);
        return list;
    }

    public List<Integer> postorder_iterative(Node root) {
        if(root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        while(root != null ){
            stack.push(root);
            if(root.children != null) {
                for (int i = root.children.size()-1; i >= 0 ; i--) {
                    stack.push(root.children.get(i));
                }
                root = stack.pop();
            } else {
                break;
            }


        }
        while(!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.val);
        }
        return list;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
