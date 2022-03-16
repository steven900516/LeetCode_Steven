package March;

import December.ListNode;

/**
 * @author Steven0516
 * @create 2022-03-16
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1,head);
        ListNode p = dummy;
        for (int i = 0; i < left; i++) {
            p = p.next;
        }
        ListNode nextHead = p;
        p = p.next;
        ListNode tail = p;
        ListNode pre = null;
        for (int i = 0; i <= right - left; i++) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        nextHead.next = pre;
        tail.next = p;
        return dummy.next;
    }
}
