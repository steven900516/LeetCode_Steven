package March;

/**
 * @author Steven0516
 * @create 2022-03-27
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums,i,nums[i] - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 != i){
                return i + 1;
            }
        }

        return n + 1;
    }

    public void swap(int[] nums,int i,int p){
        int tmp = nums[i];
        nums[i] = nums[p];
        nums[p] = tmp;
    }

    public static void main(String[] args) {
        FirstMissingPositive test = new FirstMissingPositive();
        System.out.println();
    }

}
