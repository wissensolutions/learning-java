package tree;

import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class BalancedForest {
    @Test
    public void testHealthy() {
        balancedForest(new int[]{1,2,2,1,1}, new int[][]{{1,2},{1,3},{1,4},{3,5}});
    }

     int balancedForest(int[] c, int[][] edges) {
        TreeNode root = new TreeNode(c[0],1, c[0]);
        for(int i=0; i < edges.length; i++){
            int parentName = edges[i][0];
            int nodeName = edges[i][1];
            createNode(c[nodeName-1], nodeName, parentName, root);
        }
        return 0;
    }
    private TreeNode createNode(int value, int nodeName, int parentName, TreeNode rootNode){
        TreeNode parentNode = rootNode;
        while(parentNode != null){
            if(parentNode.number == parentName){
                break;
            } else {
                if(parentNode.left != null && parentNode.left.number == parentName){
                    parentNode = parentNode.left;
                } else if(parentNode.middle != null && parentNode.middle.number == parentName){
                    parentNode = parentNode.middle;
                } else if(parentNode.right != null && parentNode.right.number == parentName ){
                    parentNode = parentNode.right;
                }
            }
        }
        if(parentNode.left == null){
            parentNode.left = new TreeNode(value, nodeName, parentNode.data + value);
        } else if(parentNode.middle == null){
            parentNode.middle = new TreeNode(value, nodeName, parentNode.data + value);
        } else if(parentNode.right == null){
            parentNode.right = new TreeNode(value, nodeName, parentNode.data + value);
        }
        return parentNode;
    }

    private static class TreeNode{
        int data;
        TreeNode left;
        TreeNode middle;
        TreeNode right;
        int number;
        int sum;

        public TreeNode(int iData, int number, int sum) {
            data = iData;
            this.number = number;
            this.sum = sum;
        }
    }
}
