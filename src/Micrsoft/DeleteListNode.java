package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-02-14
 */
public class DeleteListNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
