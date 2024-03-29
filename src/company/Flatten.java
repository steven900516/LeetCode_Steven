package company;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Steven0516
 * @create 2021-11-26
 */
public class Flatten {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }
        p.right = right;
    }
}
