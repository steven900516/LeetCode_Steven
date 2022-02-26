package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-02-24
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int vote = 0;
        int tmp = 0;
        for (int i = 0;i < nums.length;i++){
            if(vote == 0){
                tmp = nums[i];
                vote = 1;
                continue;
            }
            vote += tmp == nums[i] ? 1 : -1;
        }
        return tmp;
    }
}
