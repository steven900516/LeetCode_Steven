package company;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Steven0516
 * @create 2021-10-29
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> res = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i]);
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = res.poll();
        }

        return ans;
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.add(1);
        integers.add(-1);
        integers.add(8);
        System.out.println(integers.peek());
        System.out.println(findKthLargest.findKthLargest(new int[]{1, 5, 6, 7, 3, 4}, 2));
    }
}
