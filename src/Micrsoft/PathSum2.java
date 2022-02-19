package Micrsoft;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-02-18
 */
public class PathSum2 {
    int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        dfs(root,sum);
        return ans;
    }

    private void dfs(TreeNode root, int sum) {
        if(root == null){
            return;
        }

        verify(root,sum);
        dfs(root.left,sum);
        dfs(root.right,sum);
    }

    private void verify(TreeNode root, int sum) {
        if(root == null){
            return;
        }
        sum -= root.val;
        if(sum == 0){
            ans++;
        }
        verify(root.left,sum);
        verify(root.right,sum);
    }
}
