package company;

/**
 * @author Steven0516
 * @create 2021-11-04
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;
        while(l1 != l2){
            if(l1 == null){
                l1 = headB;
                continue;
            }
            if(l2 == null){
                l2 = headA;
                continue;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }
}
