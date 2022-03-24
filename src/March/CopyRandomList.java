package March;

/**
 * @author Steven0516
 * @create 2022-03-24
 */
public class CopyRandomList {
    public Node2 copyRandomList(Node2 head) {
        if (head == null) return null;
        Node2 dummy = new Node2(-1);
        dummy.next = head;
        while (head != null) {
            Node2 node = new Node2(head.val);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }
        head = dummy.next;
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        head = dummy.next;
        Node2 ans = head.next;
        while (head != null) {
            Node2 tmp = head.next;
            if (head.next != null) head.next = head.next.next;
            head = tmp;
        }
        return ans;
    }
}
class Node2{
    int val;
    Node2 next;
    Node2 random;

    public Node2(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
