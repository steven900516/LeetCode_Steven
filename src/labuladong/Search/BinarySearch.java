package labuladong.Search;

/**
 * @author Steven0516
 * @create 2021-10-21
 */
public class BinarySearch {

    //标准的二分搜索
    int binarySearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1; // 注意

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }


    //寻找左侧边界的二分搜索(通常使用左闭右开)
    int left_bound(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                right = mid;             //和下面的条件可以合并
            }else if(nums[mid] > target){
                right = mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }

        if (left == nums.length) return -1;
        // 类似之前算法的处理方式
        return nums[left] == target ? left : -1;
    }





    //右侧边界查找

    int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        if (left == 0) return -1;
        return nums[left-1] == target ? (left-1) : -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.left_bound(new int[]{1, 2, 2, 2, 3}, 2));

    }
}
