package Micrsoft;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-01-09
 */
public class FindBottomLeftValue {
    int maxLength = -1;
    int res = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if(root ==  null){
            return;
        }
        if(root.left == null && root.right == null){
            if(depth > maxLength){
                maxLength = depth;
                res = root.val;
            }
        }
        dfs(root.left,depth + 1);
        dfs(root.right,depth + 1);
    }
}
