package labuladong.ListNode;

/**
 * @author Steven0516
 * @create 2021-10-09
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while( slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
