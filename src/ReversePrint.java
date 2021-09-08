/**
 * @author Steven0516
 * @create 2021-09-08
 */
public class ReversePrint {

    //从尾到头打印链表
    //好方法：利用栈来实现反转
    public int[] reversePrint(ListNode head) {
        int size = 0;
        ListNode curr = new ListNode(0);
        curr.next = head;
        while(curr.next != null){
            size++;
            curr = curr.next;
        }
        int[] res = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            res[i] = head.val;
            head = head.next;
        }
        return res;
    }
}
