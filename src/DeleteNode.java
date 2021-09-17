/**
 * @author Steven0516
 * @create 2021-09-17
 */


//删除节点
public class DeleteNode {

    //遍历删除节点
    public ListNode deleteNode(ListNode head, int val) {
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode instead = tmp;
        while(tmp.next!=null){
            if(tmp.next.val == val){
                //判断后面两个节点是否为空
                if(tmp.next.next ==null){
                    tmp.next = null;
                }else{
                    tmp.next = tmp.next.next;
                }
            }else{
                tmp = tmp.next;
            }
        }
        return instead.next;
    }

    //双指针
    public ListNode deleteNode2(ListNode head, int val) {
        if(head.val == val) return head.next;
        //初始化指针
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;
        return head;
    }

}
