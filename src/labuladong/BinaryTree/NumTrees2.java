package labuladong.BinaryTree;



import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-10-14
 */
public class NumTrees2 {

    private List<TreeNode> generateTrees(int n){
        return count(1,n);
    }

    private List<TreeNode> count(int l, int r) {
        LinkedList<TreeNode> res = new LinkedList<>();
        if(l > r){
            res.add(null);
            return res;
        }

        for (int i = l; i <= r ; i++) {
            List<TreeNode> left = count(l, i - 1);
            List<TreeNode> right = count(i + 1, r);
            for(TreeNode le: left){
                for (TreeNode ri:right){
                    TreeNode root = new TreeNode(i);
                    root.left = le;
                    root.right = ri;
                    res.add(root);
                }
            }
        }
        return res;
    }




}
