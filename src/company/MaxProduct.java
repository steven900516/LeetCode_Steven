package company;

/**
 * @author Steven0516
 * @create 2021-12-02
 */
public class MaxProduct {
    public static int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i],nums[i]);
            imin = Math.min(imin * nums[i],nums[i]);
            ans = Math.max(ans,imax);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, -4}));
    }
}
