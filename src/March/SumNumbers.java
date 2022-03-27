package March;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-03-26
 */
public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }

    private int helper(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        int tmp = sum * 10 + root.val;
        if (root.left == null && root.right == null){
            return tmp;
        }
        return helper(root.left,tmp) + helper(root.right,tmp);
    }
}
