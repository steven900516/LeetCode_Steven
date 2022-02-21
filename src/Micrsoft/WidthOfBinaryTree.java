package Micrsoft;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Steven0516
 * @create 2022-02-21
 */
public class WidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.add(root);
        while(queue.isEmpty()){
            int count = queue.size();
            int num = queue.getLast().val - queue.getFirst().val + 1;
            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    cur.left.val = cur.val * 2 + 1;
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    cur.right.val = cur.val * 2 + 2;
                    queue.add(cur.right);
                }
            }
            res = Math.max(res,num);
        }
        return res;
    }
}
