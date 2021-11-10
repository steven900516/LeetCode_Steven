package company;

/**
 * @author Steven0516
 * @create 2021-11-10
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode y1 = new ListNode();
        ListNode y2 = new ListNode();
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        y1 = l1;
        y2 = l2;
        while(y1 != null && y2 != null){
            if(y1.val > y2.val){
                dummy.next = y2;
                y2 = y2.next;
            }else{
                dummy.next = y1;
                y1 = y1.next;
            }
            dummy = dummy.next;
        }
        if(y1 == null){
            dummy.next = y2;
        }

        if(y2 == null){
            dummy.next = y1;
        }

        return p.next;

    }
}
