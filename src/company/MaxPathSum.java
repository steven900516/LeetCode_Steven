package company;

/**
 * @author Steven0516
 * @create 2021-11-24
 */
public class MaxPathSum {
    int res = Integer.MIN_VALUE;
    int pathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }


    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res,root.val + left + right);
        int out = Math.max(root.val + left ,root.val + right);
        return out < 0?0:out;
    }


    public int maxPathSum2(TreeNode root) {
        dfs2(root);

        return pathSum;
    }

    // dfs 返回以该节点为端点的最大路径和
    public int dfs2(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        // 当前节点有四个选择：
        // 1）独立成线，直接返回自己的值
        // 2）跟左子节点合成一条路径
        // 3）跟右子节点合成一条路径
        int ret = Math.max(node.val, node.val + Math.max(left, right));
        // 4）以自己为桥梁，跟左、右子节点合并成一条路径
        pathSum = Math.max(pathSum, Math.max(ret, node.val + left + right));
        return ret;
    }

}
