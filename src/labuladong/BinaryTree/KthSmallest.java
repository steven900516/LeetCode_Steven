package labuladong.BinaryTree;

/**
 * @author Steven0516
 * @create 2021-10-13
 */
public class KthSmallest {
    int rank = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root,k);
        return res;
    }

    private void traverse(TreeNode root, int k){
        if(root == null){
            return;
        }
        traverse(root.left,k);
        rank++;
        if(rank == k){
            res = root.val;
        }
        traverse(root.right,k);
    }
}
