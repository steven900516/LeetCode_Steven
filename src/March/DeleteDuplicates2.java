package March;

import December.ListNode;

/**
 * @author Steven0516
 * @create 2022-03-27
 */
public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1,head);
        ListNode cur = head;
        ListNode pre = dummy;
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if (pre.next == cur){
                pre = pre.next;
            }else{
                pre.next = cur.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
