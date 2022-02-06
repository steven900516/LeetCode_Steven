package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-02-06
 */
public class RemoveNthFromEnd2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);

        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}
