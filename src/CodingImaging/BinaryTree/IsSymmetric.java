package CodingImaging.BinaryTree;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2021-12-25
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return judge(root.left,root.right);
    }

    private boolean judge(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;


        return judge(left.left,right.right) && judge(left.right,right.left);
    }
}
