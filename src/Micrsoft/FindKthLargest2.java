package Micrsoft;

import java.util.PriorityQueue;

/**
 * @author Steven0516
 * @create 2022-01-05
 */
public class FindKthLargest2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        int n = nums.length;
        return quickSort(0,nums.length - 1,nums,k);
    }

    private int quickSort(int left, int right, int[] nums, int k) {
        int pivot = partition(left,right,nums);
        if(pivot == k){
            return nums[pivot];
        }

        return pivot < k ? quickSort(pivot + 1,right,nums,k) : quickSort(left,pivot - 1,nums,k);
    }

    private int partition (int left, int right, int[] nums) {
        int pivot = left;
        int index = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if(nums[i] < nums[pivot]){
                swap(i,index,nums);
                index++;
            }
        }
        swap(pivot,index - 1,nums);
        return index - 1;
    }

    private void swap(int i, int index, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[index];
        nums[index] = tmp;
    }

}
