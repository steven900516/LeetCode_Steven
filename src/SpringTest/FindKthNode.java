package SpringTest;

import java.util.*;

/**
 * @author Steven0516
 * @create 2022-01-25
 */
public class FindKthNode {
        private Map<Integer, TreeNode> map = new HashMap<>();
        private List<Integer> res = new LinkedList<>();
        private boolean[] visited = new boolean[1024];
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            if(root == null) return res;
            findParent(root);
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(target);
            int depth = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++){
                    TreeNode node = queue.poll();
                    visited[node.val] = true;
                    if (depth == k)
                        res.add(node.val);
                    if (node.left != null && !visited[node.left.val])
                        queue.offer(node.left);
                    if (node.right != null && !visited[node.right.val])
                        queue.offer(node.right);

                    if (map.get(node.val) != null && !visited[map.get(node.val).val])
                        queue.offer(map.get(node.val));
                }
                depth++;
            }
            return res;
        }

        private void findParent(TreeNode root) {
            if (root.left != null) {
                map.put(root.left.val, root);
                findParent(root.left);
            }
            if (root.right != null) {
                map.put(root.right.val, root);
                findParent(root.right);
            }
        }



}


class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}