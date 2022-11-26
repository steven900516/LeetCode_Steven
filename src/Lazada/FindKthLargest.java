package Lazada;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

       for (Integer ints : nums) {
           queue.add(ints);
           if (queue.size() > k) {
               queue.poll();
           }
       }


       return queue.peek();
    }


    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);

//        for (Integer a : ints) {
//            ints.add(1);
//            System.out.println(a);
//        }
        for (int i = 0; i < ints.size(); i++) {
            ints.add(1);
            System.out.println(ints.get(i));
        }
    }


}
