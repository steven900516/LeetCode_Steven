package leetcode;

/**
 * @author Steven0516
 * @create 2021-09-28
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for(int num : nums)               // 1. 遍历异或
            n ^= num;
        while((n & m) == 0)               // 2. 循环左移，计算 m（记录哪一位开始不一样，并按照该位进行分组）
            m <<= 1;
        for(int num: nums) {              // 3. 遍历 nums 分组（分为0，1两个组）
            if((num & m) != 0) x ^= num;  // 4. 当 num & m != 0
            else y ^= num;                // 4. 当 num & m == 0
        }
        return new int[] {x, y};          // 5. 返回出现一次的数字
    }
}
