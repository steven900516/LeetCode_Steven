package Micrsoft;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-02-11
 */
public class IsBalanced2 {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return flag;
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        if(Math.abs(left - right) > 1){
            flag = false;
        }
        return Math.max(left,right) + 1;
    }
}
