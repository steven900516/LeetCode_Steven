package March;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Steven0516
 * @create 2022-03-20
 */
public class ZigzagLevelOrder {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(index % 2 == 0){
                    level.add(cur.val);
                }else{
                    level.addFirst(cur.val);
                }
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            ans.add(level);
            index++;
        }

        return ans;
    }
}
