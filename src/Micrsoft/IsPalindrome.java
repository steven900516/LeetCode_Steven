package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-02-07
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode middle = findMiddle(head);
        ListNode newHead = reverse(middle);
        ListNode na = head;
        ListNode p = newHead;
        while(p != null){
            if(p.val != na.val){
                return false;
            }
            na = na.next;
            p = p.next;
        }
        return true;
    }

    private ListNode reverse(ListNode middle) {
        ListNode pre = null;
        ListNode cur = middle;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode root2 = new ListNode(2);
        ListNode root3 = new ListNode(2);
        ListNode root4 = new ListNode(1);
        head.next = root2;
        root2.next = root3;
        root3.next = root4;
        IsPalindrome isPalindrome = new IsPalindrome();
        isPalindrome.isPalindrome(head);
    }
}
