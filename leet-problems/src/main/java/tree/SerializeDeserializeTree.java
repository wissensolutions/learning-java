package tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Wissen Solutions.
 */
public class SerializeDeserializeTree {
    @Test
    public void testHealthy() {
        String s1 = "[1,2,3,null,null,4,5]";
        TreeNode node = deserialize(s1);
        String s2 = serialize(node);
        Assert.assertEquals(s1,s2);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root != null) {
            sb.append("[");
            printInOrder(sb, root);
            sb.append("]");
        }
        return sb.toString();
    }

    private void printInPreOrder(StringBuilder sb, TreeNode node){
        if(node == null){
            return;
        }

//        if(node.left == null){
//            sb.append("null");
//        } else {
//            printInOrder(sb, node.left);
//        }

            sb.append(node.val).append(",");
            if(node.left == null  && node.right != null){
                sb.append("null");
            } else {
                printInOrder(sb, node.left);
            }

            if(node.right == null  && node.left != null){
                sb.append("null");
            } else {
                printInOrder(sb, node.right);
            }



//        if(node.right == null){
//            sb.append("null");
//        } else {
//            printInOrder(sb, node.right);
//        }
    }

    private void printInOrder(StringBuilder sb, TreeNode node){
        if(node == null){
            sb.append("null,");
            return;
        }

//        if(node.left == null){
//            sb.append("null");
//        } else {
//            printInOrder(sb, node.left);
//        }
        sb.append(node.val).append(",");
        printInOrder(sb, node.left);
        printInOrder(sb, node.right);
//        if(node.right == null){
//            sb.append("null");
//        } else {
//            printInOrder(sb, node.right);
//        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1,data.length()-1);
        String[] chars = data.split(",");
        TreeNode root = null;
        for(int i=0; i<chars.length; i++){
            if(chars[i] != null && !chars[i].equals( "null") ){
                if (i == 0) {
                    root = new TreeNode(Integer.parseInt(chars[i]));
                } else {
                    root = addNode(root, Integer.parseInt(chars[i]));
                }
            }
        }
        return root;
    }
    private TreeNode addNode(TreeNode node, Integer newVal){
        if(newVal == null){
            return node;
        }

        if(newVal < node.val){
            if(node.left == null){
                node.left = new TreeNode(newVal);
            } else {
                addNode(node.left, newVal);
            }
        } else {
            if(node.right == null){
                node.right = new TreeNode(newVal);
            } else {
                addNode(node.right, newVal);
            }
        }
        return node;
    }


}
