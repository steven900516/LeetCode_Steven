package company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-11-19
 */
public class HasPathSum2 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    public void dfs(TreeNode root, int targetSum){

        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val){
            res.add(new ArrayList(path));
        }
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
        path.remove(path.size() - 1);
    }
}
