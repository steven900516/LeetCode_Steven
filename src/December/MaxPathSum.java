package December;

/**
 * @author Steven0516
 * @create 2022-01-03
 */
public class MaxPathSum {
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPath;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        maxPath = Math.max(maxPath,root.val + left + right);
        return (Math.max(left,right) + root.val) < 0 ? 0 : Math.max(left,right) + root.val;
    }
}
