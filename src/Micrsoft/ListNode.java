package Micrsoft;

/**
 * @author Steven0516
 * @create 2021-12-24
 */
public class ListNode {
    int val;
    ListNode next;
    public ListNode(){};
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}
