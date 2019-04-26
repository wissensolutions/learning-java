package tree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * @author : Wissen Solutions.
 */
public class InOrderTraversalWithWhileLoop {
    @Test
    public void testHealthy() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = inorderTraversal(root);
        System.out.println(list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode head = root;
        List<Integer> traversal = new ArrayList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while(head!=null){

            if(head.left!=null){
                stack.push(head);
                head=head.left;
            }
            else {

                if(head.right!=null){
                    traversal.add(head.val);
                    head=head.right;
                }

                else{

                    traversal.add(head.val);
                    if(stack.isEmpty())
                        break;
                    while(head.right==null && !stack.isEmpty()){

                        head = stack.pop();
                        traversal.add(head.val);

                    }

                    if(head.right==null)
                        break;
                    head= head.right;

                }
            }

        }

        return traversal;
    }
}
