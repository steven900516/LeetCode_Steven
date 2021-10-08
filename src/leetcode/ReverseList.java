package leetcode;

import java.util.Stack;

/**
 * @author Steven0516
 * @create 2021-09-08
 */


// 反转链表
// 双指针较为合适
    //https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/fan-zhuan-lian-biao-yi-dong-de-shuang-zhi-zhen-jia/
public class ReverseList {
    Stack<Integer> reverse = new Stack<>();
    public ListNode reverseList(ListNode head) {
        while(head != null){
            reverse.push(head.val);
            head = head.next;
        }
        int size = reverse.size();
        ListNode newHead;
        if(size > 0){
            newHead = new ListNode(reverse.pop());
            ListNode curr = newHead;
            for (int i = 0; i < size - 1; i++) {
                ListNode listNode = new ListNode(reverse.pop());
                curr.next = listNode;
                curr = curr.next;
            }
        }else{
            return null;
        }

        return newHead;
    }


}
