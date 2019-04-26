package tree;

import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class BSTWithSortedArray {
    @Test
    public void testHealthy() {
        TreeNode root = sortedArrayToBST(new int[]{1,2,3,4,5});
        System.out.println(root);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return m1(nums, 0, nums.length);
    }

    private TreeNode m1(int[] nums, int i, int j){
        if(i >= j){
            return null;
        }
        int mid = (i+j)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left =  m1(nums, i, mid);
        node.right =  m1(nums, mid+1, j);
        return node;
    }

//    public TreeNode sortedArrayToBST(int[] nums) {
//        return getBST(nums, 0, nums.length-1);
//    }
//
//    public TreeNode getBST(int[] nums, int lo, int hi){
//        if(lo > hi){
//            return null;
//        }
//        int mid = (lo+hi)>>1;
//        TreeNode root = new TreeNode(nums[mid]);
//        root.left = getBST(nums, lo, mid-1);
//        root.right = getBST(nums, mid+1, hi);
//        return root;
//    }
}
