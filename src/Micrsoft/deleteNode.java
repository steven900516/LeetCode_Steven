package Micrsoft;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-01-11
 */
public class deleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(root.val == key){
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // 处理情况 3
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while(node.left != null) node = node.left;
        return  node;
    }
}
