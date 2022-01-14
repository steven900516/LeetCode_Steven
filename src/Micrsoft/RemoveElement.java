package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-01-14
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int ans = 0;
        for(int num: nums) {
            if(num != val) {
                nums[ans] = num;
                ans++;
            }
        }
        return ans;

    }
}
