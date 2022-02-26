package Ali;

/**
 * @author Steven0516
 * @create 2022-02-25
 */
public class Problem2 {
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum);
        return flag;
    }


    public void dfs(TreeNode root,int targetSum){
        if(root == null){
            return;
        }
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0){
            flag = true;
            return;
        }
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
    }

    public static void main(String[] args) {
        TreeNode root =  new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        Problem2 problem2 = new Problem2();
        System.out.println(problem2.hasPathSum(root,3));
    }

}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){

    }

    TreeNode(int val){
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
