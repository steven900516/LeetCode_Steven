package Micrsoft;

import leetcode.TreeNode;

import java.util.HashSet;

/**
 * @author Steven0516
 * @create 2022-02-18
 */
public class CheckSubTree {
    HashSet<String> set = new HashSet<>();
    boolean ans = false;
    String sT2;
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        String sT2 = subTree(t2,false);
        set.add(sT2);
        this.sT2 = sT2;
        subTree(t1,true);
        return ans;
    }

    private String subTree(TreeNode t2,boolean is) {
        if(t2 == null){
            return "#";
        }

        String left = subTree(t2.left,false);
        String right = subTree(t2.right,false);
        String res = t2.val + "," + left + right;

        if(is){
            if(set.contains(sT2)){
                ans = true;
            }
        }

        return res;
    }
}
