package Micrsoft;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-01-08
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root.left,root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;

        return isSymmetricHelper(left.left,right.right) && isSymmetricHelper(left.right,right.left);
    }
}
