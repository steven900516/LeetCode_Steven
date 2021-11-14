package game;

/**
 * @author Steven0516
 * @create 2021-11-14
 */
public class ReverseListNode {
    public static void main(String[] args) {
        ReverseListNode hao= new ReverseListNode();

        ListNode D= new ListNode(5);
        ListNode C= new ListNode(4,D);
        ListNode B = new ListNode(3,C);
        ListNode A = new ListNode(2, B);
        ListNode head = new ListNode(1,A);
        System.out.print("ListNode[ ");
        System.out.println(head+" ]");

        ListNode res = hao.reverseEvenLengthGroups(head);
        System.out.print("ListNode[ ");
        System.out.println(res +" ]");


    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        if(head==null || head.next==null) return head;
        return  reverse(head,1);// idx 用来标记 顺序
    }
    ListNode  reverse(ListNode head, int group ){
        if(head==null || head.next==null) return head;
        ListNode slow = head; // 每组链表的表头
        ListNode fast =  head; // 下一组链表的表头
        ListNode end= head ;// 每组链表的末尾
        int count=0; // 记录当前这组 链表的个数
        for( int i=0;i<group;++i){
            if(fast==null) { // 针对最后一组链表
                if(count<group && count%2!=0){
                    // 最后一组链表的长度为 奇数
                    ListNode tmp= reverse(fast, group+1 );
                    return slow;
                }else if(count<group &&  count %2==0){
                    // 最后一组链表的长度为 偶数
                    ListNode  newHead =reverseList(slow,fast);
                    slow.next= reverse(fast, group+1);
                    return newHead;
                }
                return null;
            }else{
                count++;
            }

            if(i<group-1){
                end=end.next;
            }

            fast=fast.next;
        }

        if(group%2!=0){
            ListNode tmp = reverse(fast, group+1);
            end.next= tmp;
            return slow;
        }else{
            ListNode  newHead =reverseList(slow,fast);
            slow.next= reverse(fast, group+1);
            return newHead;
        }

    }

    ListNode reverseList(ListNode head ,ListNode fast ){
        ListNode curNode=head;
        ListNode pre =null;
        while(curNode!=fast){
            ListNode temp= curNode.next;
            curNode.next = pre;
            pre= curNode;
            curNode=temp;
        }

        return pre;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }


        @Override
        public String toString() {
            return  val +
                    ", " + next ;
        }
    }
}