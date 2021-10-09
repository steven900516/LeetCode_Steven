package labuladong.ListNode;

/**
 * @author Steven0516
 * @create 2021-10-09
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            if(fast.next == null) break;
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
