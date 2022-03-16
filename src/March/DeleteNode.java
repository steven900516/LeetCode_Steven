package March;


import December.ListNode;

/**
 * @author Steven0516
 * @create 2022-03-13
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy;
        while(p != null){
            if(p.next.val == val){
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }

        return dummy.next;
    }
}
