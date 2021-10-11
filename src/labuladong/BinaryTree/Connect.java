package labuladong.BinaryTree;

/**
 * @author Steven0516
 * @create 2021-10-11
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
        connectTwo(right.left,right.right);
        connectTwo(left.right,right.left);
    }
}
