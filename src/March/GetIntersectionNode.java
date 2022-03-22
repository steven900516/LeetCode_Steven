package March;

import December.ListNode;

/**
 * @author Steven0516
 * @create 2022-03-20
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB){
            if(pA == null){
                pA = headB;
                continue;
            }
            if(pB == null){
                pB = headA;
                continue;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
    }
}
