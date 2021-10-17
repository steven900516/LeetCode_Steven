package labuladong.BinaryTree;

/**
 * @author Steven0516
 * @create 2021-10-15
 */
public class MaxSumBST {
    int sumMax;
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return sumMax;
    }

    private int[] traverse(TreeNode root){
        if(root == null){
            return new int[] {
                    1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0
            };
        }

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        int[] res = new int[4];
        if (left[0] == 1 && right[0] == 1 &&
                root.val > left[2] && root.val < right[1]) {
            // 以 root 为根的二叉树是 BST
            res[0] = 1;
            // 计算以 root 为根的这棵 BST 的最小值
            res[1] = Math.min(left[1], root.val);
            // 计算以 root 为根的这棵 BST 的最大值
            res[2] = Math.max(right[2], root.val);
            // 计算以 root 为根的这棵 BST 所有节点之和
            res[3] = left[3] + right[3] + root.val;
            // 更新全局变量
            sumMax = Math.max(sumMax, res[3]);
        } else {
            // 以 root 为根的二叉树不是 BST
            res[0] = 0;
            // 其他的值都没必要计算了，因为用不到
        }
        /**************************/

        return res;
    }
}
