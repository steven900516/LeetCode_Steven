package labuladong.BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-10-13
 */
public class FindDuplicateSubtrees {
    private HashMap<String,Integer> memory = new HashMap<>();
    private LinkedList<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root){
        if(root == null){
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + "," + right + "," + root.val;
        int count = memory.getOrDefault(subTree,0);
        if(count == 1){
            res.add(root);
        }
        memory.put(subTree,count + 1);
        return subTree;
    }
}
