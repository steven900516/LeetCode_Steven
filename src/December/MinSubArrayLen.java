package December;

/**
 * @author Steven0516
 * @create 2021-12-15
 */
public class MinSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {
        int length = Integer.MAX_VALUE;
        int sum = 0;
        for(int left = 0,right  = 0;right < nums.length;right++){
            sum += nums[right];
            if(sum >= target){
                length = Math.min(length,right - left + 1);
                sum = 0;
                right = left;
                left ++;
            }

        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }


    public static void main(String[] args) {
        int[] ints = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, ints));
    }
}
