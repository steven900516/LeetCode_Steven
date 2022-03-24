package March;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-03-22
 */
public class Merge2 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(o1 , o2)-> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= end){
                end = Math.max(end,intervals[i][1]);
            }else{
                res.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start,end});
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            int[] eve = res.get(i);
            ans[i][0] = eve[0];
            ans[i][1] = eve[1];
        }
        return ans;
    }
}
