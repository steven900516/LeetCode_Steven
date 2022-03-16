package March;

/**
 * @author Steven0516
 * @create 2022-03-13
 */
public class TreeToDoublyList {
    Node pre;
    Node head;
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node root) {
        if(root == null){
            return;
        }

        dfs(root.left);
        if(pre == null){
            head = root;
        }else{
            pre.right = root;
        }
        root.left = pre;
        pre = root;

        dfs(root.right);
    }


}
