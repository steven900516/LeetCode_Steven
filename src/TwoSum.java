/**
 * @author shkstart
 * @create 2021-07-12 11:22
 */
public class TwoSum {
    public int[] solution(int[] nums, int target){
        int index = 0;
        int[] tar = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <  nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    tar[index] = i;
                    tar[index + 1] = j;
                    index += 2;
                }
            }
        }
        return tar;
    }
}
