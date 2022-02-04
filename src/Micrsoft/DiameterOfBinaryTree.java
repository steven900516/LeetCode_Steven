package Micrsoft;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-02-04
 */
public class DiameterOfBinaryTree {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        count(root);
        return res;
    }

    private int count(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = count(root.left);
        int right = count(root.right);
        res = Math.max(res,left + right);
        return Math.max(left,right) + 1;
    }
}
