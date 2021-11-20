package company;

/**
 * @author Steven0516
 * @create 2021-11-20
 */
public class ReverseBetween {
    ListNode access;
    public ListNode reverseN(ListNode head, int n){
        if(n == 1){
            access = head.next;
            return head;
        }

        ListNode listnode = reverseN(head.next,n - 1);
        head.next.next = head;
        head.next = access;
        return listnode;
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == 1){
            return reverseN(head,right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }
}
