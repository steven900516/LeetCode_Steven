package December;

/**
 * @author Steven0516
 * @create 2021-12-08
 */
public class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        for(int i = 0;i < k;i++){
            if(fast == null){
                return head;
            }
            fast = fast.next;
        }
        ListNode nHead = reverse(slow,fast);
        slow.next = reverseKGroup(fast,k);
        return nHead;
    }

    public ListNode reverse(ListNode slow,ListNode fast){
        ListNode cur = slow;
        ListNode pre = null;
        while(cur != fast){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
