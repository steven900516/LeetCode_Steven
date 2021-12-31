package Micrsoft;

import leetcode.TreeNode;
import sun.reflect.generics.tree.Tree;

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
        Map<Integer,Integer> res = new HashMap<>();
        Set<Integer> integers = res.keySet();

        if(min != null && root.val <= min.val){
            return false;
        }
        if(max != null && root.val >= max.val){
            return false;
        }


        return judge(root.left,min,root) && judge(root.right,root,max);

    }
}
