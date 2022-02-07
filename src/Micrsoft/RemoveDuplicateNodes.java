package Micrsoft;

import java.util.HashSet;

/**
 * @author Steven0516
 * @create 2022-02-07
 */
public class RemoveDuplicateNodes {

    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy;
        while(p != null && p.next != null){
            if(set.contains(p.next.val)){
                p.next = p.next.next;
            }else {
                set.add(p.next.val);
                p = p.next;
            }
        }

        return dummy.next;
    }
}
