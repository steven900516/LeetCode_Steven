package labuladong.ListNode;

/**
 * @author Steven0516
 * @create 2021-10-11
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null|| k == 0)  return head;
        int n = 0;			   //链表的长度
        ListNode tail = null;  //尾节点
        for(ListNode p = head; p != null ; p = p.next){
            tail = p;
            n++;
        }
        k %= n;
        ListNode p = head;
        for(int i = 0; i < n - k - 1; i++)  p = p.next;   //找到链表的第n-k个节点
        tail.next = head;
        head = p.next;
        p.next = null;
        return head;  //返回新的头节点

    }
}
