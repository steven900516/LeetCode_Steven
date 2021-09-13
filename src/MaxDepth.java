/**
 * @author Steven0516
 * @create 2021-09-13
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepth(treeNode));
    }
}
