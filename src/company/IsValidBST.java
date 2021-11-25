package company;

/**
 * @author Steven0516
 * @create 2021-11-25
 */
public class IsValidBST {
    boolean isValidBST(TreeNode root){
        return isValidBST2(root, null, null);
    }

    boolean isValidBST2(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null)  return true;
        if(min != null && root.val <= min.val) return false;
        if(max != null && root.val >= max.val)  return false;
        return isValidBST2(root.left,min,root) && isValidBST2(root.right,root,max);
    }
}
