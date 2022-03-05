package Ali;

import java.util.*;

/**
 * @author Steven0516
 * @create 2022-03-03
 */
public class NetworkDelayTime {
    List<int[]>[] graph;


    public int networkDelayTime(int[][] times, int n, int k) {
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int[] line : times){
            int source = line[0];
            int det = line[1];
            int weight = line[3];
            graph[source].add(new int[]{det,weight});
        }


        int[] res = dijkstra(k,graph);
        int ans = 0;
        for (int i = 1; i <= n ; i++) {
            if(res[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans,res[i]);
        }

        return ans;
    }

    private int[] dijkstra(int k, List<int[]>[] graph) {
        int n = graph.length;
        int[] distTo = new int[n];
        Arrays.fill(distTo,Integer.MAX_VALUE);
        distTo[k] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>(new Comparator<State>() {
            @Override
            public int compare(State o1, State o2) {
                return o1.distFromStart - o2.distFromStart;
            }
        });
        pq.add(new State(k,0));

        while(!pq.isEmpty()){
            State curState = pq.poll();
            int curID = curState.id;
            int curDistance = curState.distFromStart;
            if(curDistance > distTo[curID]){
                continue;
            }

            for (int[] eve: graph[curID]){
                int curToNext = curDistance + eve[1];
                if(curToNext < distTo[eve[0]]){
                    distTo[eve[0]] = curToNext;
                    pq.add(new State(eve[0],curToNext));
                }
            }
        }

        return distTo;
    }




}
