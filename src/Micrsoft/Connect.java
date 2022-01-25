package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-01-25
 */
public class Connect {

    public Node connect(Node root) {
        if(root == null) return null;
        connectTwo(root.left,root.right);
        return root;
    }

    private void connectTwo(Node left, Node right) {
        if(left == null || right == null){
            return;
        }

        left.next = right;
        connectTwo(left.left,left.right);
        connectTwo(left.right,right.left);
        connectTwo(right.left,right.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
