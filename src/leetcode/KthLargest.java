package leetcode;

import java.util.ArrayList;

/**
 * @author Steven0516
 * @create 2021-09-21
 */


//二叉搜索树的第k大节点 （利用中序遍历）

    //更好的方法贼是使用逆序的中序遍历  右中左


public class KthLargest {
    ArrayList<Integer> res = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        backTrack(root);
        return res.get(res.size() - k);
    }


    private void backTrack(TreeNode root){
        if(root == null){
            return;
        }
        backTrack(root.left);
        res.add(root.val);
        backTrack(root.right);
    }
}
