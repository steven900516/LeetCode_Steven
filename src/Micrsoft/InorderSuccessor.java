package Micrsoft;

import leetcode.TreeNode;

import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2022-02-11
 */
public class InorderSuccessor {
    TreeNode pre = null;
    TreeNode ans = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root,p);
        return ans;
    }

    private void dfs(TreeNode root,TreeNode p) {

        if(root == null){
            return;
        }

        dfs(root.left,p);
        if(pre == p){
            ans = root;
        }
        pre = root;
        dfs(root.right,p);
    }
}
