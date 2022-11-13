package Micrsoft;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Steven0516
 * @create 2021-12-29
 */
public class IsValidBST {
    boolean isValidBST(TreeNode root){
        return judge(root, null, null);
    }

    private boolean judge(TreeNode root, TreeNode min, TreeNode max) {


        if(min != null && root.val <= min.val){
            return false;
        }
        if(max != null && root.val >= max.val){
            return false;
        }


        return judge(root.left,min,root) && judge(root.right,root,max);

    }

    TreeNode pre;
    boolean flag = true;
    public boolean isValidBST2(TreeNode root) {
        dfs(root);
        return flag;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);

        if(pre != null && root.val <= pre.val){
            System.out.println("pre : "+ pre.val + ", cur : " + root.val);
            flag = false;
        }
        pre = root;
        dfs(root.right);

    }
}
