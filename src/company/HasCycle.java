package company;

/**
 * @author Steven0516
 * @create 2021-11-15
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head,fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
