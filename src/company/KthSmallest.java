package company;

/**
 * @author Steven0516
 * @create 2021-12-01
 */
public class KthSmallest {
    int res = 0;
    int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return res;
    }


    public void dfs(TreeNode root,int k){
        if(root == null){
            return;
        }

        dfs(root.left,k);
        rank++;
        if(rank == k){
            res = root.val;
            return;
        }

        dfs(root.right,k);
    }
}
