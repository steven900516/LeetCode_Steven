package Micrsoft;

import java.util.LinkedList;

/**
 * @author Steven0516
 * @create 2022-02-23
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        if(head == null){
            return new int[]{};
        }
        LinkedList<Integer> list = new LinkedList<>();
        while(head != null){
            list.addFirst(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
