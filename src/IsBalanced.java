/**
 * @author Steven0516
 * @create 2021-09-24
 */
public class IsBalanced {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        maxDepth(root);
        return flag;
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            if(Math.abs(left - right) > 1){
                flag = false;
            }
            return Math.max(left, right) + 1;
        }
    }
}
