/**
 * @author Steven0516
 * @create 2021-09-19
 */

//调整数组顺序使奇数位于偶数前面
    //双指针
public class Exchange {
    public int[] exchange(int[] nums) {
        if(nums.length == 0){
            return nums;
        }
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            if(nums[i] % 2 == 0 && nums[j] % 2 != 0 ){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j--;
            }else if(nums[i] % 2 == 0 && nums[j] % 2 == 0 ){
                j--;
            }else if(nums[i] % 2 != 0 && nums[j] % 2 != 0){
                i ++;
            }else{
                i++;
                j--;
            }
        }
        return nums;
    }
}
