package labuladong.ListNode;

/**
 * @author Steven0516
 * @create 2021-10-10
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return head;
        }

        ListNode a,b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if(b == null){
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverseList(a,b);
        a.next = reverseKGroup(b,k);
        return newHead;
    }

    private ListNode reverseList(ListNode a, ListNode b) {
        ListNode curr = a;
        ListNode pre = null;
        while(curr != b){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

//    public ListNode reverseKGroup(ListNode head, int k) {
//        if (head == null) return null;
//        // 区间 [a, b) 包含 k 个待反转元素
//        ListNode a, b;
//        a = b = head;
//        for (int i = 0; i < k; i++) {
//            // 不足 k 个，不需要反转，base case
//            if (b == null) return head;
//            b = b.next;
//        }
//        // 反转前 k 个元素
//        ListNode newHead = reverse(a, b);
//        // 递归反转后续链表并连接起来
//        a.next = reverseKGroup(b, k);
//        return newHead;
//    }
//    /** 反转区间 [a, b) 的元素，注意是左闭右开 */
//    ListNode reverse(ListNode a, ListNode b) {
//        ListNode pre, cur, nxt;
//        pre = null; cur = a; nxt = a;
//        // while 终止的条件改一下就行了
//        while (cur != b) {
//            nxt = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = nxt;
//        }
//        // 返回反转后的头结点
//        return pre;
//    }
}
