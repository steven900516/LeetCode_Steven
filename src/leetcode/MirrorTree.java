package leetcode;

/**
 * @author Steven0516
 * @create 2021-09-13
 */

//镜像二叉树
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }

        /**** 前序遍历位置 ****/
        // root 节点需要交换它的左右子节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;


        // 让左右子节点继续翻转它们的子节点
        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }
}
