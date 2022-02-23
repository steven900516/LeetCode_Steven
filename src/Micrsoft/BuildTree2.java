package Micrsoft;

import leetcode.TreeNode;

import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2022-02-23
 */
public class BuildTree2 {
    int[] preOrder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        this.preOrder = preorder;
        int n = preorder.length - 1;
        return build(map,0,0,n);
    }

    private TreeNode build(HashMap<Integer, Integer> map, int root, int left, int right) {
        if(left > right){
            return null;
        }
        TreeNode node = new TreeNode(preOrder[root]);
        int index = map.get(preOrder[root]);
        node.left = build(map,root + 1,left,index - 1);
        node.right = build(map,root + index - left + 1,index + 1,right);
        return node;
    }
}
