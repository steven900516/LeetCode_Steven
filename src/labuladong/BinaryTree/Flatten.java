package labuladong.BinaryTree;

/**
 * @author Steven0516
 * @create 2021-10-12
 */
public class Flatten {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode pointer = root;
        while(pointer.right != null){
            pointer = pointer.right;
        }
        pointer.right = right;
    }
}
