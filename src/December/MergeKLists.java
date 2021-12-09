package December;

import java.util.PriorityQueue;

/**
 * @author Steven0516
 * @create 2021-12-09
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b)-> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        for(ListNode l: lists){
            if(l != null){
                queue.offer(l);
            }
        }

        while(!queue.isEmpty()){
            ListNode tmp = queue.poll();
            p.next = tmp;
            if(tmp.next != null){
                queue.offer(tmp.next);
            }
            p = p.next;
        }

        return dummy.next;
    }
}
