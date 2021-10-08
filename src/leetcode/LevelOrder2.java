package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Steven0516
 * @create 2021-09-12
 */

//从上到下打印二叉树
public class LevelOrder2 {

    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        int[] res;
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
        Integer[] arr = list.toArray(new Integer[list.size()]);
        res = new int[arr.length];
        for(int i = 0; i < arr.length; i ++)
            res[i] = arr[i];
        return res;

    }
}
