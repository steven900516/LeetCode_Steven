package labuladong.ListNode;

import java.util.List;

/**
 * @author Steven0516
 * @create 2021-10-09
 */
public class ReverseList {
    public ListNode reverseList(ListNode head){
        if (head.next == null) return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;  //打断当前结点的指针域 + 修改指针域
        head.next = null;
        return last;
    }

    public ListNode reverseList2(ListNode pHead){
        if(pHead==null || pHead.next == null){ //如果没有结点或者只有一个结点直接返回pHead
            return pHead;
        }
        ListNode pNext = pHead.next; //保存当前结点的下一结点
        pHead.next = null; //打断当前结点的指针域
        ListNode reverseHead = reverseList2(pNext); //递归结束时reverseHead一定是新链表的头结点
        pNext.next = pHead; //修改指针域
        return reverseHead;
    }
}
