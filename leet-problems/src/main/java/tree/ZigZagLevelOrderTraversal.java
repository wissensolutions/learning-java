package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Wissen Solutions.
 */
public class ZigZagLevelOrderTraversal {
    @Test
    public void testHealthy() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left =  new TreeNode(15);
        root.right.right =  new TreeNode(7);
        List<List<Integer>> list  = zigzagLevelOrder(root);
        System.out.println(list);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> returnList = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(root!= null && !queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i =0;i<size; i++){
                TreeNode node =  queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            if(returnList.size()%2 != 0){
                Collections.reverse(levelList);
            }
            returnList.add(levelList);
        }
        return returnList;
    }

}
