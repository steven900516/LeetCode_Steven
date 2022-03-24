package March;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-03-24
 */
public class BinaryTreePaths {
    List<String> res = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        recur(root,new StringBuilder());
        return res;
    }

    private void recur(TreeNode root, StringBuilder sb) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            res.add(sb.toString() + root.val);
            return;
        }

        int start = sb.length();
        sb.append(root.val + "->");
        int end = sb.length();
        recur(root.left,sb);
        recur(root.right,sb);
        sb.delete(start,end);
    }
}
