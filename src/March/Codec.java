package March;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;
import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Steven0516
 * @create 2022-03-14
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur != null){
                sb.append(cur.val + ",");
            }else{
                sb.append("null,");
                continue;
            }
            queue.add(cur.left);
            queue.add(cur.right);
        }

        sb.delete(sb.length() - 1,sb.length());
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] value = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(value[0]));
        int i = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(!value[i].equals("null")){
                cur.left = new TreeNode(Integer.parseInt(value[i]));
                queue.add(cur.left);
            }
            i++;
            if(!value[i].equals("null")){
                cur.right = new TreeNode(Integer.parseInt(value[i]));
                queue.add(cur.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node.left = node2;
        node.right = node3;
        node3.left = node4;
        node3.right = node5;
        Codec codec = new Codec();
        System.out.println(codec.serialize(node));
    }
}
