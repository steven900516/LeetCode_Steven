/**
 * @author Steven0516
 * @create 2021-09-18
 */


public class GetIntersectionNode {

    //双指针，时间复杂度为O(n),空间复杂度为O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;


        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
