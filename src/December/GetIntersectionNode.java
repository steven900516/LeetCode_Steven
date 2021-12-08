package December;

/**
 * @author Steven0516
 * @create 2021-12-08
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2){
            if(p1 == null){
                p1 = headB;
                continue;
            }
            if(p2 == null){
                p2 = headA;
                continue;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
