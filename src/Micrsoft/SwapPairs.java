package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-01-13
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < 2; i++) {
            if(fast == null){
                return head;
            }
            fast = fast.next;
        }
        ListNode newHead = reverseList(slow, fast);
        ListNode listNode = swapPairs(fast);

        slow.next = listNode;
        return newHead;
    }

    private ListNode reverseList(ListNode slow, ListNode fast) {
        ListNode cur = slow;
        ListNode pre = null;
        while(cur != fast){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }


}
