package Micrsoft;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-01-09
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return isHelper(root) == -1 ? false : true;
    }


    public int isHelper(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = isHelper(root.left);
        if (left == -1) {
            return -1;
        }
        int right = isHelper(root.right);
        if (right == -1){
            return -1;
        }
        int sub = Math.abs(left - right);
        if(sub > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
