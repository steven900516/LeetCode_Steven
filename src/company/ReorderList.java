package company;

/**
 * @author Steven0516
 * @create 2021-11-11
 */
public class ReorderList {
    public static void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!= null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverser = reverser(slow.next);
        slow.next = null;
        System.out.println("slow: "  + slow.val);
        System.out.println("reverser: " + reverser.val);

        ListNode h1 = head;
        System.out.println(h1.next.val);
        while(h1 != null && reverser != null){
            ListNode l1Next = h1.next;
            ListNode l2Next = reverser.next;
            h1.next = reverser;
            reverser.next = l1Next;
            h1 = l1Next;
            reverser = l2Next;
        }
    }

    public static  ListNode reverser(ListNode listNode){
        ListNode pre = null;
        ListNode cur = listNode;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(7);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        reorderList(listNode);
    }
}
