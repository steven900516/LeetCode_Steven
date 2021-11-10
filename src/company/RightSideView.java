package company;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Steven0516
 * @create 2021-11-10
 */
public class RightSideView {


    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }

                if(i == size - 1) res.add(curr.val);
            }
        }

        return res;
    }

}
