package Micrsoft;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-02-19
 */
public class CanFinish {
    List<Integer>[] graph;
    boolean[] visited;
    boolean[] onPath;
    boolean isCycle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new List[numCourses];
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int[] order : prerequisites){
            graph[order[1]].add(order[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            dfs(graph,i);
        }
        return isCycle;
    }

    private void dfs(List<Integer>[] graph, int i) {
        if(onPath[i]){
            isCycle = true;
        }

        if(visited[i] || isCycle){
            return;
        }

        visited[i] = true;
        onPath[i] = true;
        for (Integer in : graph[i]) {
            dfs(graph,in);
        }
        onPath[i] = false;
    }
}
