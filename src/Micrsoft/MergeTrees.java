package Micrsoft;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-01-11
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        if(root1 == null || root2 == null){
            return root1 == null ? root2 : root1;
        }
        TreeNode head = new TreeNode(root1.val + root2.val);
        head.left = mergeTrees(root1.left,root2.left);
        head.right = mergeTrees(root1.right,root2.right);
        return head;
    }
}
