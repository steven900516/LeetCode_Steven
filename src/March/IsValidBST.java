package March;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-03-29
 */
public class IsValidBST {
    TreeNode pre = null;
    TreeNode cur;
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return flag;
    }

    public void dfs(TreeNode root){
        if (root == null){
            return;
        }

        dfs(root.left);
        if (pre != null){
            if (pre.val > root.val){
                flag = false;
            }
        }
        pre = root;
        dfs(root.right);
    }
}
