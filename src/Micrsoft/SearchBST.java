package Micrsoft;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-01-11
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val){
            return root;
        }
        if(root.val < val){
            return searchBST(root.right,val);
        }else{
            return searchBST(root.left,val);
        }
    }
}
