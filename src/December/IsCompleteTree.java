package December;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Steven0516
 * @create 2021-12-12
 */
public class IsCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        while((node = queue.poll()) != null) {
            queue.offer(node.left);
            queue.offer(node.right);
        }

        for(TreeNode n : queue) {
            if(n != null)
                return false;
        }
        return true;

    }
}
