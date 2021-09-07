import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-09-07
 */

//组合总共2     力扣40题回溯算法
/*
    注意回溯的时候，我们需要在搜索的过程中就进行去重
    而要实现去重，首先要对candidates数组进行排序，利用candidates[i] == candidates[i -1]进行去重

 */
public class CombinationSum2 {
    List<List<Integer>> res = new ArrayList<>();        // 用于存储最后的返回结果
    LinkedList<Integer> track = new LinkedList<>();     // 存储单次的返回结果

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);               // 先进行排序
        backtrack(0, target, 0, candidates);
        return res;
    }

    // 递归函数
    public void backtrack(int curSum, int target, int start, int[] candidates) {
        // base case
        if (curSum == target) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < candidates.length && curSum + candidates[i] <= target; i++) {
            // 进行去重的操作
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 做选择
            curSum += candidates[i];
            track.add(candidates[i]);
            // 递归遍历
            backtrack(curSum, target, i + 1, candidates);
            // 回溯，撤销选择
            curSum -= candidates[i];
            track.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] candidates = new int[]{1,1,2,7,6,1,5};
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum2(candidates, 2));
    }
}
