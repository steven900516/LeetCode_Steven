package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Steven0516
 * @create 2021-09-23
 */
//最小的k个数
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0 || arr.length == 0){
            return new int[0];
        }
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr,0,k);
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) { // 排除 0 的情况
            return vec;
        }

        //建大堆  （Java默认为小堆  所以重写compare）
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }

        return vec;

    }

    public static void main(String[] args) {
        //小堆测试
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.offer(2);
        integers.offer(20);
        integers.offer(17);
        integers.offer(80);
        integers.offer(40);
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println(integers.size());
//        while(!integers.isEmpty()) {
//            int t = integers.poll();
//            System.out.println(t);
//        }

    }
}
