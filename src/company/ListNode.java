package company;

/**
 * @author Steven0516
 * @create 2021-10-08
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static  void traverse(ListNode head) {
        if (head == null) return;

        traverse(head.next);
        // 后序遍历代码
        System.out.println(head.val);
    }


}
