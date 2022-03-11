package March;

import leetcode.TreeNode;

import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2022-03-09
 */
public class BuildTree {

    HashMap<Integer,Integer> map = new HashMap<>();
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        this.preorder = preorder;
        return helpTree(map,0,0,preorder.length - 1);
    }

    private TreeNode helpTree(HashMap<Integer, Integer> map, int root, int left, int right) {
        if(left > right){
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);
        int index = map.get(preorder[root]);
        node.left = helpTree(map,root + 1,left,index - 1);
        node.right = helpTree(map,root + index - left + 1,index + 1,right);
        return node;
    }
}
