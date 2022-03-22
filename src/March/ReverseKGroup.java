package March;

import December.ListNode;

/**
 * @author Steven0516
 * @create 2022-03-19
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            if(fast == null){
                return fast;
            }
            fast = fast.next;
        }
        ListNode newHead = reverseNode(slow,fast);
        ListNode listNode = reverseKGroup(fast, k);
        slow.next = listNode;
        return newHead;
    }

    private ListNode reverseNode(ListNode slow, ListNode fast) {
        ListNode pre = null;
        ListNode cur = slow;
        while(cur != fast){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
