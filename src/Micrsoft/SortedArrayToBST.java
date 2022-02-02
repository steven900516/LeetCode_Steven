package Micrsoft;

import leetcode.TreeNode;

/**
 * @author Steven0516
 * @create 2022-02-02
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0,nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int l, int r) {
        if(l > r){
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = dfs(nums, l, mid - 1);
        TreeNode right = dfs(nums, mid + 1, r);
        root.left = left;
        root.right = right;
        return root;
    }
}
