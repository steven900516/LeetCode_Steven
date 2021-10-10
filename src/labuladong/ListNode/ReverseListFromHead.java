package labuladong.ListNode;

/**
 * @author Steven0516
 * @create 2021-10-10
 */
public class ReverseListFromHead {
    ListNode successor = null;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) return reverseN(head, right);
        // 这里也是递归的方式解决问题，其实可以for循环走到left节点处
        // 注意需要对head.next重新赋值，否则链表就断开了。
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }
    private ListNode reverseN(ListNode head, int n) {
        // 需要全局存下N+1个节点
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 和全部反转的区别就在这里，全部反转head就是最后一个节点，head.next=null
        // 反转前N个节点，头结点的会连上N+1个节点，即head.next=successor
        head.next = successor;
        return last;
    }
}
