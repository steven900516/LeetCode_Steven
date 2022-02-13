package Micrsoft;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-02-11
 */
public class IsValidBST2 {

    TreeNode pre = null;
    boolean res = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }

        dfs(root.left);
        if(pre != null){
            if(root.val < pre.val){
                res = false;
            }
        }
        pre = root;
        dfs(root.right);
    }
}
