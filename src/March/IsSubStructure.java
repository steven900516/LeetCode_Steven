package March;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-03-13
 */
public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return false;
        }
        boolean mid = helper(A,B);
        boolean left = isSubStructure(A.left,B);
        boolean right = isSubStructure(A.right,B);
        return mid || left || right;
    }

    private boolean helper(TreeNode left, TreeNode B) {
        if(B == null){
            return true;
        }

        if(left == null || left.val != B.val){
            return false;
        }

        return helper(left.left,B.left) && helper(left.right,B.right);
    }
}
