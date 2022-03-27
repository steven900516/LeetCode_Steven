package March;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-03-25
 */
public class IsSubStructure2 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null ||B == null){
            return false;
        }
        boolean judge = recur(A,B);
        boolean left = isSubStructure(A.left,B);
        boolean right = isSubStructure(A.right,B);

        return judge || left || right;
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if(B == null){
            return true;
        }
        if (A == null || A.val != B.val){
            return false;
        }

        return recur(A.left,B.left) || recur(A.right,B.right);
    }
}
