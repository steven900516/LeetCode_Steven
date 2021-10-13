package labuladong.BinaryTree;

import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2021-10-13
 */
public class BuildTree2 {
    int[] postorder;
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(inorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode recur(int root, int left, int right) {
        if(left > right) return null;
        TreeNode node = new TreeNode(postorder[root]);
        int i = dic.get(postorder[root]);
        node.left = recur(root - right + i - 1, left, i - 1);
        node.right = recur(root - 1, i + 1, right);
        return node;
    }
}
