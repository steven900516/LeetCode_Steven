package labuladong.Dynamic;



import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2021-11-10
 */
public class Rob3 {

    HashMap<TreeNode,Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(memo.containsKey(root)){
            return memo.get(root);
        }

        int do_rob = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int no_rob = rob(root.left) + rob(root.right);

        int res = Math.max(do_rob,no_rob);
        memo.put(root,res);
        return res;
    }
}
