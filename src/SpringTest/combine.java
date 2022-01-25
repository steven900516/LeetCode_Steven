package SpringTest;

/**
 * @author Steven0516
 * @create 2022-01-25
 */
public class combine {
    public ListNode combine(ListNode head){
        if(head == null ||head.next == null) return null;

        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode dummy2 = new ListNode(-1,p2);

        while(p2 != null && p2.next != null){
            p1.next = p1.next.next;
            p1 = p1.next.next;
            p2 = p2.next;
            p2 = p2.next;
        }

        p1.next = dummy2.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode(1);
        ListNode root2 = new ListNode(2);
        ListNode root3 = new ListNode(3);
        ListNode root4 = new ListNode(4);
        ListNode root5 = new ListNode(5);
        root1.next = root2;
        root2.next = root3;
        root3.next = root4;
        root4.next = root5;
        ListNode combine = new combine().combine(root1);
        ListNode p = combine;
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
}


class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}