package Micrsoft;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-02-19
 */
public class AllPathsSourceTarget {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        if(n == 0){
            return  res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        backTrack(graph,0,path);
        return res;
    }

    private void backTrack(int[][] graph,int point, LinkedList<Integer> path) {
        path.add(point);
        if(point == graph.length - 1){
            res.add(new LinkedList<>(path));
            return;
        }

        for (int v : graph[point]){
            backTrack(graph, v, path);
        }
        path.removeLast();
    }
}
