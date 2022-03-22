package March;

import java.util.PriorityQueue;

/**
 * @author Steven0516
 * @create 2022-03-19
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if(queue.size() > k){
                queue.poll();
            }
        }

        return queue.peek();
    }
}
