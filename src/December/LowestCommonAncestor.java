package December;

/**
 * @author Steven0516
 * @create 2021-12-09
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root == p ? p : q;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null && right == null){
            return null;
        }
        if(left == null || right == null){
            return left == null ? right : left;
        }else{
            return root;
        }
    }
}
