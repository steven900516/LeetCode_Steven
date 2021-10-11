package labuladong.ListNode;

/**
 * @author Steven0516
 * @create 2021-10-11
 */
public class IsPalindrome {
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    private boolean traverse(ListNode right) {
        if(right == null){
            return true;
        }
        boolean res = traverse(right.next);
        res = res && (left.val == right.val);
        left = left.next;
        return res;
    }


    public boolean isPalindrome2(ListNode head) {
        ListNode slow,fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = reverse(slow);

        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;


    }

    public ListNode reverse(ListNode pHead){
        if(pHead==null || pHead.next == null){ //如果没有结点或者只有一个结点直接返回pHead
            return pHead;
        }
        ListNode pNext = pHead.next; //保存当前结点的下一结点
        pHead.next = null; //打断当前结点的指针域
        ListNode reverseHead = reverse(pNext); //递归l结束时reverseHead一定是新链表的头结点
        pNext.next = pHead; //修改指针域
        return reverseHead;
    }


}
