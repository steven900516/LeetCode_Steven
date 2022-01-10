package Micrsoft;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-01-10
 */
public class PathSum {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root,path,targetSum);
        return res;
    }

    private void dfs(TreeNode root, LinkedList<Integer> path,int targetSum) {
        if(root == null){
            return;
        }


        path.add(root.val);

        if(root.left == null && root.right == null && targetSum == root.val){
            res.add(new LinkedList<>(path));
        }
        dfs(root.left,path,targetSum - root.val);
        dfs(root.right,path,targetSum - root.val);
        path.removeLast();
        // targetSum = targetSum + root.val;
    }
}
