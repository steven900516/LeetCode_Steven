package Micrsoft;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-02-04
 */
public class DeleteNode2 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode p = root.right;
            while (p.left != null){
                p = p.left;
            }
            root.val = p.val;
            root.right = deleteNode(root.right,p.val);
        }else if(root.val > key){
            root.left = deleteNode(root.left,key);
        }else if(root.val < key){
            root.right = deleteNode(root.right,key);
        }
        return root;
    }


}
