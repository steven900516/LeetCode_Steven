package leetcode;

/**
 * @author shkstart
 * @create 2021-08-02 13:53
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            len ++ ;
        }
        ListNode dummy = new ListNode(0,head);
        cur = dummy;
        for (int i = 0; i < len - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
