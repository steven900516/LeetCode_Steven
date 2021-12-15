package December;

/**
 * @author Steven0516
 * @create 2021-12-15
 */
public class deleteDuplicates {


    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        //维护一个不变的结点guard
        ListNode guard=new ListNode();
        guard.next=head;
        ListNode pre=guard;
        ListNode cur=head;
        while(cur!=null){
            //如果出现重复的情况如下
            //相等的结点则跳过,走到相同值元素的最后一步
            while(cur.next!=null&&cur.next.val==cur.val) cur=cur.next;
            //如果pre和cur之间没有重复节点，pre后移
            if(pre.next==cur)  pre=pre.next;
                //将cur的前指针向后移动一位
            else pre.next=cur.next;
            cur=cur.next;
        }
        return guard.next;
    }
}
