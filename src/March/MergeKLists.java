package March;

import December.ListNode;

import java.util.PriorityQueue;

/**
 * @author Steven0516
 * @create 2022-03-22
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)-> (a.val - b.val));
        for (ListNode l:lists){
            if(l != null){
                queue.offer(l);
            }
        }
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while(!queue.isEmpty()){
            ListNode poll = queue.poll();
            if(poll.next != null){
                queue.offer(poll.next);
            }
            p.next = poll;
            p = p.next;
        }

        return dummy.next;
    }
}
