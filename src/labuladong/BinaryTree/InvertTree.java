package labuladong.BinaryTree;

/**
 * @author Steven0516
 * @create 2021-10-11
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode TreeNode1 = invertTree(root.left);
        TreeNode TreeNode2 = invertTree(root.right);
        root.left = TreeNode2;
        root.right = TreeNode1;
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode l = new TreeNode(1);
        TreeNode r = new TreeNode(3);
        root.left = l;
        root.right = r;
        InvertTree invertTree = new InvertTree();
        invertTree.invertTree(root);
    }
}
