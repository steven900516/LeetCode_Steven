import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Steven0516
 * @create 2021-09-12
 */
public class LevelOrder3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> eve = new LinkedList<>();
        if(root == null){
            return res;
        }
        eve.add(root);
        while(!eve.isEmpty()){
            ArrayList<Integer> integers = new ArrayList<>();
            int size = eve.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = eve.poll();
                integers.add(curr.val);
                if(curr.left != null){
                    eve.add(curr.left);
                }
                if(curr.right != null) {
                    eve.add(curr.right);
                }
            }
            res.add(integers);
        }
        return res;
    }
}
