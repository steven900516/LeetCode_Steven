package March;

import java.util.PriorityQueue;

/**
 * @author Steven0516
 * @create 2022-03-19
 */
public class FindKthLargest2 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,0,nums.length - 1,nums.length - k);
    }

    private int quickSort(int[] nums, int start, int end, int k) {
        int pivot = partiotion(nums,start,end);
        if(pivot == k){
            return nums[pivot];
        }
        return pivot > k ? quickSort(nums,start,pivot - 1,k) : quickSort(nums,pivot + 1,end,k);
    }

    private int partiotion(int[] nums, int start, int end) {
        int pivotIdx = start;
        int count = start + 1;
        for (int i = start + 1; i <= end ; i++) {
            if(nums[i] < nums[pivotIdx]){
                swap(nums,i,count);
                count++;
            }
        }
        swap(nums,pivotIdx,count - 1);
        return count - 1;
    }

    private void swap(int[] nums,int i,int count){
        int tmp = nums[i];
        nums[i] = nums[count];
        nums[count] = tmp;
    }
}
