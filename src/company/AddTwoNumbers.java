package company;

/**
 * @author Steven0516
 * @create 2021-12-01
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int flag = 0;
        while(l1 != null || l2 != null){
            int x = l1 == null? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + flag;
            flag = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null){
                l2 = l2.next;
            }


        }
        if(flag > 0){
            cur.next = new ListNode(flag);
        }
        return dummy.next;
    }
}
