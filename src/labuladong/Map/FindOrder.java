package labuladong.Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-10-18
 */
public class FindOrder {
    boolean[] onPath;
    // 记录遍历过的节点，防止走回头路
    boolean[] visited;
    // 记录图中是否有环
    boolean hasCycle = false;
    List<Integer> postorder = new ArrayList<>();

    boolean[] visited2;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (!canFinish(numCourses, prerequisites)) {
            return new int[]{};
        }
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited2 = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse2(graph, i);
        }


        Collections.reverse(postorder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = postorder.get(i);
        }
        return res;

    }


    void traverse2(List<Integer>[] graph, int s){
        if(visited2[s]){
            return;
        }
        visited2[s] = true;
        for(int t: graph[s]){
            traverse2(graph,t);
        }
        postorder.add(s);
    }

    boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            // 遍历图中的所有节点
            traverse(graph, i);
        }
        // 只要没有循环依赖可以完成所有课程
        return !hasCycle;
    }

    void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            // 出现环
            hasCycle = true;
        }

        if (visited[s] || hasCycle) {
            // 如果已经找到了环，也不用再遍历了
            return;
        }
        // 前序遍历代码位置
        visited[s] = true;
        onPath[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        // 后序遍历代码位置
        onPath[s] = false;
    }

    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            // 修完课程 from 才能修课程 to
            // 在图中添加一条从 from 指向 to 的有向边
            graph[from].add(to);
        }
        return graph;
    }
}
