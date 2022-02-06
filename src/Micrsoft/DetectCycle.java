package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-02-06
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
