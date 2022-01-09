package Micrsoft;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-01-09
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumHelper(root);
    }

    private int sumHelper(TreeNode root) {
        if(root == null) return 0;

        int left = sumHelper(root.left);
        int right = sumHelper(root.right);
        int total = left + right;
        if (root.left != null && root.left.left == null && root.left.right == null){
            total += root.left.val;
        }
        return total;
    }
}
