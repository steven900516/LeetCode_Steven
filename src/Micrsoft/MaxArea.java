package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-02-18
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int ans = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int min = Math.min(height[left],height[right]);
            ans = Math.max(ans,min * (right - left));
            if(height[left] == min){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}
