package labuladong.ListNode;

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

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(7);
        ListNode listNode3 = new ListNode(9);
        ListNode listNode4 = new ListNode(20);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode.traverse(listNode);
    }
}
