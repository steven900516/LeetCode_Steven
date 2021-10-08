package leetcode;

/**
 * @author shkstart
 * @create 2021-07-17 10:04
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            res = Math.max(res, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int[] ints = new int[]{1,2,4,3};
        int i = maxArea.maxArea(ints);
        System.out.println(i);
    }
}
