package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Steven0516
 * @create 2021-09-08
 */

//复杂链表的复制
//回溯算法
public class CopyRandomList {
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
