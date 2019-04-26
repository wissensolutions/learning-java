package tree;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Wissen Solutions.
 */
public class BinaryTreeFromInorderAndPreOrder {
    @Test
    public void testHealthy() {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] preorder = new int[]{3,9,20,15,7};
        TreeNode node = buildTree(preorder,inorder);
        System.out.println(node);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        if(preorder.length == 1){
            return new TreeNode(preorder[0]);
        }

        Map<Integer, Integer> inorderMap = new HashMap<>();
        // Build the map with elements and it's indexes

        for(int i=0;i<inorder.length; i++){
            inorderMap.put(inorder[i],i );
        }

        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length; i++){
            int inOrderIndex = inorderMap.get(preorder[i]);
            TreeNode node = root;
            while(node != null){
                int parentNodeIndex = inorderMap.get(node.val);
                if(inOrderIndex < parentNodeIndex){
                    // left side
                    if(node.left == null){
                        node.left = new TreeNode(preorder[i]);
                        break;
                    } else {
                        node = node.left;
                    }
                } else {
                    // right side
                    if(node.right == null){
                        node.right = new TreeNode(preorder[i]);
                        break;
                    } else {
                        node = node.right;
                    }
                }
            }
        }
        return root;
    }

}
