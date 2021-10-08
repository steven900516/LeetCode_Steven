package labuladong.ListNode;



/**
 * @author Steven0516
 * @create 2021-10-08
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cop = head;
        while(! (l1 == null && l2 == null)){
            if(l1 == null){
                head.next = l2;
                l2 = l2.next;
            }else if (l2 == null){
                head.next = l1;
                l1 = l1.next;
            }else if(l1.val > l2.val){
                ListNode tmp = l2;
                head.next = tmp;
                l2 = l2.next;
            }else{
                ListNode tmp = l1;
                head.next = tmp;
                l1 = l1.next;
            }
            head = head.next;
        }
        return cop.next;
    }


}
