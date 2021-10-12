package labuladong.BinaryTree;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2021-10-12
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(Arrays.copyOf(nums,index));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums,index + 1,nums.length));
        return root;
    }
}
