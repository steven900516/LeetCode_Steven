package labuladong.BinaryTree;

/**
 * @author Steven0516
 * @create 2021-10-14
 */
public class IsValidBST {
    boolean isValidBST(TreeNode root){
        return isValidBST2(root, null, null);
    }

    boolean isValidBST2(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST2(root.left, min, root)
                && isValidBST2(root.right, root, max);
    }


    TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空位置插入新节点
        if (root == null) return new TreeNode(val);
        // if (root.val == val)
        //     BST 中一般不会插入已存在元素
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        return root;
    }


    TreeNode deleteNode(TreeNode root, int key){
        if(root == null){
            return root;
        }
        if(root.val == key){
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // 处理情况 3
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;

    }

    private TreeNode getMin(TreeNode node) {
        while(node.left != null) node = node.left;
        return  node;
    }
}
