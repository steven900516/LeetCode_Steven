package Micrsoft;

import leetcode.TreeNode;

import java.util.*;

/**
 * @author Steven0516
 * @create 2022-02-13
 */
public class BinaryTreeStack {
    LinkedList<Integer> res = new LinkedList<>();

    public List preOrderTraverse(TreeNode root){
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if(pop.right != null){
                stack.add(pop.right);
            }
            if(pop.left != null){
                stack.add(pop.left);
            }
        }

        return res;
    }

    public List inOrderTraverse(TreeNode root){
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode p = root;
        while(p != null || !stack.isEmpty()){
            if(p != null){
                res.add(p.val);
                p = p.left;
            }else{
                p = stack.pop();
                if(p.right != null){
                    stack.add(p.right);
                }
                res.add(p.val);
                p = p.right;
            }
        }

        return res;
    }

    // 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
