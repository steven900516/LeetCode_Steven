package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-01-13
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy;
        ListNode slow = p;
        ListNode fast = p;
        for(int i = 0;i <= n;i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
