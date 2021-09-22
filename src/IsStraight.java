import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2021-09-22
 */


//扑克牌中的顺子
public class IsStraight {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        //统计0的个数
        for(int i = 0; i < nums.length;i++){
            if(nums[i] == 0){
                count++;
            }
        }

        for(int i = 1;i < nums.length;i++){
            if(nums[i] - nums[i - 1] != 1 && nums[i - 1] != 0){
                //两个数相同直接返回false
                if(nums[i] == nums[i - 1]){
                    return false;
                }
                //若没有0则返回false
                if(count == 0){
                    return false;
                }
                count -= nums[i] - nums[i - 1] - 1;
                if(count < 0){return false;}
            }
        }
        return true;
    }
}
