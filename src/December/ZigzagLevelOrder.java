package December;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Steven0516
 * @create 2021-12-08
 */
public class ZigzagLevelOrder {
    LinkedList<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> path = new LinkedList<>();
            for(int i = 0;i < size;i++){
                TreeNode tmp = queue.poll();
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }

                if(count % 2 == 0){
                    path.addLast(tmp.val);
                }else{
                    path.addFirst(tmp.val);
                }
            }
            count++;
            res.add(path);
        }
        return res;
    }
}
