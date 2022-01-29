package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-01-27
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        int ans = 1;
        for(int i = 0;i < nums.length;i++){
            ans ^= nums[i];
        }
        return ans == 0;
    }
}
