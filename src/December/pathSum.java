package December;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-01-02
 */
public class pathSum {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {
        if(root == null){
            return;
        }
        path.add(root.val);
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0){
            res.add(new LinkedList<>(path));
            return;
        }
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
        path.remove(path.size() - 1);
    }
}
