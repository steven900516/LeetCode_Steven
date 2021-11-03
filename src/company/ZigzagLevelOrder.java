package company;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Steven0516
 * @create 2021-11-02
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList();
        if(root == null){
            return res;
        }
        queue.add(root);
        LinkedList<Integer> tmp = new LinkedList<>();
        tmp.add(root.val);
        res.add(tmp);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> path = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                    TreeNode every = queue.poll();
                    if(every.left != null){
                        queue.offer(every.left);
                    }
                    if (every.right != null){
                        queue.offer(every.right);
                    }

                    if(level % 2 == 0){
                        path.addLast(every.val);
                    }else{
                        path.addFirst(every.val);
                    }
            }
            level++;
            res.add(path);
        }
        return res;
    }



}
