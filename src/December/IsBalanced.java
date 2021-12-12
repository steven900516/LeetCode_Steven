package December;

/**
 * @author Steven0516
 * @create 2021-12-12
 */
public class IsBalanced {
    boolean isValid = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isValid;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        if(Math.abs(left - right) > 1){
            isValid = false;
        }
        return Math.max(left,right) + 1;
    }
}
