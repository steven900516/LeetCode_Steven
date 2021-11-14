package company;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Steven0516
 * @create 2021-11-14
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            LinkedList<Integer> path = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                path.add(node.val);
            }
            res.add(path);
        }

        return res;
    }
}
