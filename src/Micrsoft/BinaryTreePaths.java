package Micrsoft;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-01-09
 */
public class BinaryTreePaths {
    List<String> res = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,new StringBuilder());
        return res;
    }

    private void dfs(TreeNode root,StringBuilder sb) {
        if(root == null){
            return;
        }

        int start = sb.length();
        if(root.left == null && root.right == null){
            sb.append(root.val);
            res.add(sb.toString());
        }else{
            sb.append(root.val + "->");
        }
        int end = sb.length();
        dfs(root.left,sb);
        dfs(root.right,sb);
        sb.delete(start,end);
    }
}
