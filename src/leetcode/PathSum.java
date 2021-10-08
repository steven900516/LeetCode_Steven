package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-09-21
 */
public class PathSum {
    ArrayList<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        LinkedList<Integer> tmp = new LinkedList<>();
        backTrack(root,target,tmp);
        return res;
    }

    private void backTrack(TreeNode root, int target,LinkedList<Integer> tmp) {
        if(root == null){
            return;
        }
        tmp.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(tmp));
        }
        backTrack(root.left,target,tmp);
        backTrack(root.right,target,tmp);
        tmp.removeLast();
    }
}
