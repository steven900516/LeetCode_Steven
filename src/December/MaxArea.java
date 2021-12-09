package December;

/**
 * @author Steven0516
 * @create 2021-12-09
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while(left < right){
            int cur = Math.min(height[left],height[right]) * (right - left);
            res = Math.max(cur,res);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
