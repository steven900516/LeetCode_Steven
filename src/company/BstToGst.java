package company;

/**
 * @author Steven0516
 * @create 2021-12-01
 */
public class BstToGst {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    public void traverse(TreeNode root){
        if(root == null){
            return;
        }

        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}
