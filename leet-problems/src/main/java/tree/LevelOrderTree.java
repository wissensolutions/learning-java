//package tree;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * @author : Wissen Solutions.
// */
//public class LevelOrderTree {
//    @Test
//    public void testHealthy() {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(3);
//        Assert.assertTrue(isSymmetric(root));
//    }
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new LinkedList<>();
//        LinkedList<TreeNode> queue = new LinkedList<>();
//
//        if(root==null) return res;
//
//        queue.offer(root);
//
//        int size = 0;
//        while(!queue.isEmpty()){
//            List<Integer> l = new LinkedList<>();
//            size = queue.size();
//
//            for(int i = 0; i<size; i++){
//                TreeNode cur = queue.pop();
//                l.add(cur.val);
//                if(cur.left != null) queue.offer(cur.left);
//                if(cur.right != null) queue.offer(cur.right);
//            }
//            res.add(l);
//        }
//        return res;
//    }
//
////    public List<List<Integer>> levelOrder(TreeNode root) {
////        if(node == null){
////            return null;
////        }
////        List<List<Integer> list = new ArrayList<>();
////        Stack<TreeNode> stack = new Stack<>();
////        stack.push(root);
////        while(!stack.isEmpty()){
////            List<Integer> list = new ArrayList<>();
////            TreeNode node = stack.pop();
////            if(node.left != null){
////                list.add(node.left.val);
////                stack.push(node.left);
////            }
////            if(node.right != null){
////                list.add(node.right.val);
////                stack.push(node.right);
////            }
////        }
////
////    }
//
////    public List<List<Integer>> levelOrder(TreeNode root) {
////        List<List<Integer>> list = new ArrayList<>();
////        list.add(printNode(root));
////        return list;
////    }
////    private List<Integer> printNode(TreeNode root){
////        List<Integer> list = new ArrayList<>();
////        list.add(root.val);
////        Stack<TreeNode> stack = new Stack<>();
////        stack.push(root);
////        while(stack)
////        return list;
////    }
////    private List<Integer> levelOrderRecursive(TreeNode node,List<Integer> nodeList) {
////        if(node == null){
////            return null;
////        }
////
////    }
//
//}
