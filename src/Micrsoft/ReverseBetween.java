package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-01-15
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy;
        for (int i = 1; i < left; i++) {
            p = p.next;
        }
        ListNode nextNode = p.next;
        ListNode cur = null;
        ListNode pre = null;
        for(int i = left;i <= right;i++){
            cur = nextNode.next;
            nextNode.next = pre;
            pre = nextNode;
            nextNode = cur;
        }
        p.next.next = cur;
        p.next = pre;
        return dummy.next;
    }
}
