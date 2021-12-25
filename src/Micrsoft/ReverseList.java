package Micrsoft;

/**
 * @author Steven0516
 * @create 2021-12-24
 */
public class ReverseList {
    public ListNode reverseList(ListNode head){
        if(head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode nextHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return nextHead;
    }
}
