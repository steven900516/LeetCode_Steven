package March;

import leetcode.TreeNode;

import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2022-03-27
 */
public class BuildTree2 {

    //
    HashMap<Integer,Integer> map = new HashMap<>();
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return helper(0,0,inorder.length - 1);
    }

    private TreeNode helper(int root, int left, int right) {
        if (left > right){
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);
        int index = map.get(node);
        node.left = helper(root + 1,left,index - 1);
        node.right = helper(root + index - left + 1,index + 1,right);
        return node;
    }
}
