package March;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-03-24
 */
public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }

        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode p = left;
        while(p.right != null){
            p = p.right;
        }
        p.right = right;
    }
}
