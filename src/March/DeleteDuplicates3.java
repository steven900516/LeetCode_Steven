package March;

import December.ListNode;

/**
 * @author Steven0516
 * @create 2022-03-27
 */
public class DeleteDuplicates3 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null){
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }

            if (pre == cur){
                pre = pre.next;
            }else{
                pre.next = cur.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
