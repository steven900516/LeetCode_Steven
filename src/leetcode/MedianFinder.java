package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Steven0516
 * @create 2021-09-23
 */


//数据流中的中位数

public class MedianFinder {
    //建立两个堆
    Queue<Integer> A, B;
    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        if(A.size() != B.size()) {

            A.add(num);
            B.add(A.poll());
        } else {

            //先压入B大堆再poll保证最大值，在压入A小堆
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
