package company;

import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2021-11-22
 */
public class BuildTree {

    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return dfs(preorder,0,0,inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int root, int left, int right) {
        if(left > right){
            return null;
        }

        TreeNode head = new TreeNode(preorder[root]);
        int index = map.get(head.val);
        head.left = dfs(preorder,root + 1,left,index - 1);
        head.right = dfs(preorder,root + index - left + 1,index + 1,right);
        return head;
    }
}
