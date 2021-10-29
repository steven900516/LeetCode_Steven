package company;



/**
 * @author Steven0516
 * @create 2021-10-29
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        // ListNode pre = null;
        // ListNode cur = head;
        // while(cur != null){
        //     ListNode next = cur.next;
        //     cur.next = pre;
        //     pre = cur;
        //     cur = next;
        // }
        // return pre;

        if(head.next == null){
            return head;
        }


        ListNode tail = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return tail;
    }
}
