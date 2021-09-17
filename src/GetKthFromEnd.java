/**
 * @author Steven0516
 * @create 2021-09-17
 */


//链表中倒数第n个节点
public class GetKthFromEnd {

    //先算取链表长度，在进行length-k次next操作并返回
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dummy = head;
        int length = 0;
        while(dummy != null){
            length++;
            dummy = dummy.next;
        }
        if(length == k){
            return head;
        }
        for(int i = 1;i <= length - k;i++ ){
            head = head.next;
        }
        return head;
    }



    //双指针   former，latter两个指针
    public ListNode getKthFromEnd2(ListNode head, int k) {
        //初始化都指向头节点
        ListNode former = head, latter = head;
        //将latter向后移动k个单位，使得former和latter指针相距k
        for(int i = 0; i < k; i++)
            former = former.next;
        //同步移动指针，直到latter指针为空退出循环
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

}
