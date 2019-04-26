package tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author : Wissen Solutions.
 */
public class CheckSymmetricTree {
    @Test
    public void testHealthy() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(3);
        Assert.assertTrue(isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        //return isSymmetric(root.left, root.right);
        return isSymmetricInIterative(root);
    }

    private boolean isSymmetric(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val == root2.val){
            return isSymmetric(root1.left, root2.right) && isSymmetric(root2.left, root1.right);
        }
        return false;
    }

    private boolean isSymmetricInIterative(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node1 = stack.pop();
            TreeNode node2  = stack.pop();
            if(node1 == null && node2 == null){
                continue;
            }
            if(node1 == null || node2 == null){
                return false;
            }
            if(node1.val != node2.val){
                return false;
            }

            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }
        return true;
    }


}
