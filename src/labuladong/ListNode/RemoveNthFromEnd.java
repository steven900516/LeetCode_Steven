package labuladong.ListNode;

/**
 * @author Steven0516
 * @create 2021-10-09
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < n;i++){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while(true){
            fast = fast.next;
            if(fast != null){
                slow = slow.next;
            }else{
                slow.next = slow.next.next;
                slow = slow.next;
                break;
            }

        }
        return head;
    }
}
