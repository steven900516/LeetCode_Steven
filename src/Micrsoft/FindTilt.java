package Micrsoft;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-01-25
 */
public class FindTilt {
    int res;
    public int findTilt(TreeNode root) {
        if(root == null)  return 0;
        helper(root);
        return res;
    }

    int helper(TreeNode root){
        if(root == null)  return 0;


        int left = helper(root.left);
        int right = helper(root.right);
        res += Math.abs(right - left);

        return left + right + root.val;
    }
}
