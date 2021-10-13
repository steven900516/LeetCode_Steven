package labuladong.BinaryTree;

import java.util.LinkedList;

/**
 * @author Steven0516
 * @create 2021-10-13
 */
public class ConvertBST {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}
