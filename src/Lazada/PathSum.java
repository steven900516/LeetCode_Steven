package Lazada;

import company.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PathSum {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        recur(root,targetSum,path);

        return res;
    }

    private void recur(TreeNode root, int targetSum,List<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.val == targetSum && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }

        recur(root.left,targetSum - root.val,path);
        recur(root.right,targetSum - root.val,path);
        path.remove(path.size() - 1);
    }
}
