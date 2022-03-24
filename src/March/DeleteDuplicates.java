package March;

import December.ListNode;

/**
 * @author Steven0516
 * @create 2022-03-22
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if(pre.next == cur){
                pre.next = cur;
            }else {
                pre.next = cur.next;
            }
            cur = cur.next;
            pre = pre.next;
        }
        return dummy.next;
    }
}
