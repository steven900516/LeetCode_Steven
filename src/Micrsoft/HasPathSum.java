package Micrsoft;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-01-10
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }


    public boolean dfs(TreeNode root,int targetSum){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return dfs(root.left,targetSum - root.val) || dfs(root.right,targetSum - root.val);
    }
}
