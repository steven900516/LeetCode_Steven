package March;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-03-27
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return judge(root.left,root.right);
    }

    private boolean judge(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null || left.val != right.val){
            return false;
        }

        return judge(left.left,right.right) || judge(left.right,right.left);
    }
}
