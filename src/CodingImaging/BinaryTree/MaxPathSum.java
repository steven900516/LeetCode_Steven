package CodingImaging.BinaryTree;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2021-12-25
 */
public class MaxPathSum {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res,root.val + left + right);
        int out = Math.max(root.val + left, root.val + right);
        return out < 0 ? 0 : out;
    }
}
