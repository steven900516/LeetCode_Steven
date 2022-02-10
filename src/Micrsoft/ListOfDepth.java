package Micrsoft;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Steven0516
 * @create 2022-02-10
 */
public class ListOfDepth {
    LinkedList<ListNode> res = new LinkedList<>();
    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while(!queue.isEmpty()){
            int size = queue.size();
            ListNode root = null;
            ListNode p = root;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(i == 0){
                    root = new ListNode(poll.val);
                }else{
                    p.next = new ListNode(poll.val);
                    p = p.next;
                }
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
                res.add(root);
            }

        }
        ListNode[] ans = new ListNode[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}
