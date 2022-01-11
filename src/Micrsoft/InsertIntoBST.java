package Micrsoft;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-01-11
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val < val){
            root.right = insertIntoBST(root.right,val);
        }
        if(root.val > val){
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }
}
