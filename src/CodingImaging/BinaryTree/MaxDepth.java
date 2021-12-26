package CodingImaging.BinaryTree;

import java.util.List;

/**
 * @author Steven0516
 * @create 2021-12-26
 */
public class MaxDepth {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int depth = 0;
        for(Node children : root.children){
            depth = Math.max(depth,maxDepth(children));
        }

        return depth + 1;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
