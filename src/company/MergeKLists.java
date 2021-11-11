package company;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Steven0516
 * @create 2021-11-11
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        //小堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,(a,b)->(a.val-b.val));


        for(ListNode head: lists){
            queue.offer(head);
        }

        while(!queue.isEmpty()){
            ListNode small = queue.poll();
            p.next = small;
            if(small.next != null){
                queue.offer(small.next);
            }
            p = p.next;
        }

        return dummy.next;
    }
}
