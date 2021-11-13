package company;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2021-11-12
 */

//https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                Arrays.sort(nums, i, len);
                for (int j = i; j <len; j++) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
        return;
    }



    public static void main(String[] args) {
        int[] ints = new int[]{3,2,1};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(ints);

    }
}
