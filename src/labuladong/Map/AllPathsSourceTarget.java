package labuladong.Map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-10-17
 */
public class AllPathsSourceTarget {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    /* 图的遍历框架 */
    void traverse(int[][] graph, int s, LinkedList<Integer> path) {

        // 添加节点 s 到路径

        path.addLast(s);
        System.out.println("添加" +  s + "到路径");

        int n = graph.length;
        if (s == n - 1) {
            // 到达终点
            res.add(new LinkedList<>(path));
            System.out.println("到达终点--" + path.removeLast());

            return;
        }

        // 递归每个相邻节点
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }

        // 从路径移出节点 s
        System.out.println("从路径移除" + path.removeLast());

    }


/*
----------------------------------------------------
 */

    public static List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        dfs(graph, 0, path, paths);
        return paths;
    }

    // DFS回溯，cur：当前来到的位置，path：当前的DFS路径，paths：如果深度搜索到终点，形成的path加入paths
    private static void dfs(int[][] graph, int cur, LinkedList<Integer> path, List<List<Integer>> paths) {
        if (cur == graph.length-1) { // 到达终点，收集
            paths.add(new ArrayList<>(path));
            return;
        }
        int[] nexts = graph[cur];
        for (int next : nexts) {
            path.add(next);
            dfs(graph, next, path, paths);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        AllPathsSourceTarget allPathsSourceTarget = new AllPathsSourceTarget();
        System.out.println(allPathsSourceTarget.allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
    }
}
