/**
 * @author Steven0516
 * @create 2021-09-10
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int tmp;
        if(nums[0] != 0){
            return 0;
        }else{
            tmp = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] != tmp){
                    return tmp;
                }
                tmp++;
            }
        }
        return tmp;
    }
}
