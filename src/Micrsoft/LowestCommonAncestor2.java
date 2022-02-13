package Micrsoft;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-02-11
 */
public class LowestCommonAncestor2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q){
            return root == p ? p : q;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null && right == null){
            return null;
        }else if(left == null || right == null){
            return left == null ? right : left;
        }else{
            return root;
        }
    }
}
