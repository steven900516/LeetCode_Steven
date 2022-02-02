package Micrsoft;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-02-02
 */
public class ConvertBiNode {
    TreeNode pre = null;
    TreeNode head;
    public TreeNode convertBiNode(TreeNode root) {
        inOrder(root);
        return head;
    }

    void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        convertBiNode(root.left);
        if(pre == null){
            root.left = null;
            head = root;
        }else{
            root.left = null;
            pre.right = root;
        }
        pre = root;
        convertBiNode(root.right);
    }
}
