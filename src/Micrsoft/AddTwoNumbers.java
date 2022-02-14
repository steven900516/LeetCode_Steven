package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-02-14
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == l2){
            return null;
        }
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        int flag = 0;
        ListNode root = new ListNode();
        ListNode p = root;
        while(l1 != null || l2 != null){
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + flag;
            flag = sum / 10;
            p.next = new ListNode(sum % 10);
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            p = p.next;
        }
        if(flag != 0){
            p.next = new ListNode(flag);
        }
        return root.next;
    }
}
