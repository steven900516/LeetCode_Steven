package leetcode;

/**
 * @author Steven0516
 * @create 2021-09-25
 */

//二叉搜索树的最近公共祖先
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //若两个节点都在左子树，则遍历左子树
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        //若两个节点都在右子树
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
