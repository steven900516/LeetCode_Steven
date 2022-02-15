package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-02-14
 */
public class RemoveElement2 {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
