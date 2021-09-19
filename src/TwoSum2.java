/**
 * @author Steven0516
 * @create 2021-09-19
 */



//和为S的两个数字
public class TwoSum2 {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = length - 1;
            while(left <= right){
                int mid = (left + right)/2;
                int need = target - nums[i];
                if(nums[mid] == need){
                    return new int[]{nums[i],nums[mid]};
                }else if(nums[mid] > need){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }

        }
        int[] ints = new int[0];
        return ints;
    }


    //双指针
    public int[] tuoSum2(int[] nums, int target){
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target) i++;
            else if(s > target) j--;
            else return new int[] { nums[i], nums[j] };
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum2 twoSum2 = new TwoSum2();
        int[] ints = twoSum2.twoSum(new int[]{14, 15, 16, 22, 53, 60}, 76);
        for(int n: ints){
            System.out.println(n);
        }
    }
}
