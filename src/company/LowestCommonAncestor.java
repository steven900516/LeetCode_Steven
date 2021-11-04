package company;

/**
 * @author Steven0516
 * @create 2021-11-04
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root == p||root == q){
            return root;
        }

        //左子树  p，q的公共祖先为left
        TreeNode left = lowestCommonAncestor(root.left,p,q);

        //右子树 p,q的公共祖先为right
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null){
            return root;
        }else if(left == null && right != null){
            return right;
        }else if(left != null && right == null){
            return left;
        }
        return null;
    }
}
