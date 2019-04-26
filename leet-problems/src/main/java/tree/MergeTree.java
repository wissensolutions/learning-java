package tree;

import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class MergeTree {
    @Test
    public void testHealthy() {
        TreeNode tree1= new TreeNode(1);
        tree1.left = new TreeNode(3);
        tree1.left.left = new TreeNode(5);
        tree1.right = new TreeNode(2);

        TreeNode tree2= new TreeNode(2);
        tree2.left = new TreeNode(1);
        tree2.left.right = new TreeNode(4);
        tree2.right = new TreeNode(3);
        tree2.right.right = new TreeNode(7);

        TreeNode rootNode = mergeTrees(tree1, tree2);

        System.out.println("Test");
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        int resultVal = 0;
        TreeNode newNode = null;
        if(t1 != null && t2 != null){
            resultVal = t1.val+ t2.val;
            newNode = new TreeNode(resultVal);
            newNode.left = mergeTrees(t1.left, t2.left);
            newNode.right = mergeTrees(t1.right, t2.right);
        } else if(t1 == null && t2 != null){
            resultVal = t2.val;
            newNode = new TreeNode(resultVal);
            newNode.left = mergeTrees(null, t2.left);
            newNode.right = mergeTrees(null, t2.right);
        } else if(t1 != null && t2 == null){
            resultVal = t1.val;
            newNode = new TreeNode(resultVal);
            newNode.left = mergeTrees(t1.left, null);
            newNode.right = mergeTrees(t1.right, null);
        }
        return newNode;
    }


}
