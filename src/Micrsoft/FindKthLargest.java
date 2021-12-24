package Micrsoft;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Steven0516
 * @create 2021-12-24
 */
public class FindKthLargest {
    public static  int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static  int findKthLargest2(int[] nums, int k){
        return quickSort(0,nums.length - 1,nums, nums.length - k);
    }

    private static int quickSort(int l, int r, int[] nums, int target) {
        int pivot = partition(l,r,nums);
        if (pivot == target) {
            return nums[pivot];
        } else {
            return pivot < target ? quickSort(pivot + 1,r,nums,target) : quickSort(l,pivot - 1,nums,target);
        }


    }

    private static int partition(int l, int r, int[] nums) {
        int pivot = l;
        int counter = l + 1;
        for (int i = l + 1; i <= r; i++) {
            if(nums[i] < nums[pivot]){
                swap(i,counter,nums);
                counter++;
            }
        }

        swap(counter - 1,pivot,nums);
        return counter - 1;

    }

    private static void swap(int i, int counter, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[counter];
        nums[counter] = tmp;
    }


}
