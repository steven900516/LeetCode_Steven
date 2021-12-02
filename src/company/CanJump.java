package company;

/**
 * @author Steven0516
 * @create 2021-12-02
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int k = 0;
        for(int i = 0;i < nums.length;i++){
            if(k < i){
                return false;
            }
            k = Math.max(k,i + nums[i]);
        }
        return true;
    }
}
