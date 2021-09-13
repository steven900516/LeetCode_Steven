/**
 * @author Steven0516
 * @create 2021-09-13
 */

//树的子结构
public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A== null || B==null){
            return false;
        }
        boolean r1 = recur(A,B);
        boolean r2 = isSubStructure(A.left,B);
        boolean r3 = isSubStructure(A.right,B);
        return r1||r2||r3;
    }

    public boolean recur(TreeNode A, TreeNode B){
        if(B == null){
            return true;
        }
        if(A ==null|| A.val != B.val){
            return false;
        }
        return recur(A.left,B.left) && recur(A.right,B.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode21 = new TreeNode(4);
        TreeNode treeNode22 = new TreeNode(1);
        TreeNode treeNode23 = new TreeNode(2);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode21.left = treeNode22;
        treeNode21.right = treeNode23;

        IsSubStructure isSubStructure = new IsSubStructure();

        System.out.println(isSubStructure.isSubStructure(treeNode1, treeNode21));
    }
}
