package December;

/**
 * @author Steven0516
 * @create 2021-12-17
 */
public class DiameterOfBinaryTree {

    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans - 1;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        ans =  Math.max(left + right + 1,ans);
        return Math.max(left,right) + 1;
    }
}
