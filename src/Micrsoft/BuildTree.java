package Micrsoft;

import leetcode.TreeNode;

import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2022-01-10
 */
public class BuildTree {
    HashMap<Integer,Integer> map = new HashMap<>();
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return buildHelper(postorder.length - 1,0,postorder.length);
    }

    private TreeNode buildHelper(int root, int left, int right) {
        if(left > right){
            return null;
        }

        TreeNode node = new TreeNode(postorder[root]);
        int i = map.get(postorder[root]);
        node.left = buildHelper(root - right + i - 1, left, i - 1);
        node.right = buildHelper(root - 1, i + 1, right);
        return node;
    }
}
