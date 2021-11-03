package labuladong.Dynamic;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2021-10-31
 */
public class SuperEggDrop {
    public int superEggDrop(int K, int N) {
        int[][] memo = new int[K + 1][N + 1];
        for (int[] item : memo) {
            Arrays.fill(item, -1);
        }
        return superEggDropMemo(K, N, memo);
    }

    public int superEggDropMemo(int K, int N, int[][] memo) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        if (memo[K][N] != -1) {
            return memo[K][N];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            res = Math.min(res, Math.max(superEggDropMemo(K - 1, i - 1, memo), superEggDropMemo(K, N - i, memo)) + 1);
        }
        memo[K][N] = res;
        return res;
    }




    //
    public int superEggDrop2(int k, int n) {
        int[][] memo = new int[k + 1][n + 1];
        for(int i = 0; i < k + 1; i++){
            Arrays.fill(memo[i], -1);
        }
        return dp(k, n, memo);
    }

    private int dp(int k, int n, int[][] memo){
        if(k == 1) return n;
        if(n <= 0) return 0;
        if(memo[k][n] != -1) return memo[k][n];
        int res = Integer.MAX_VALUE;
        int lo = 1;
        int hi = n;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            int broken = dp(k - 1, mid - 1, memo);
            int noBroken = dp(k , n - mid, memo);
            if(broken > noBroken){
                hi = mid - 1;
                res = Math.min(res, broken + 1);
            }else{
                lo = mid + 1;
                res = Math.min(res, noBroken + 1);
            }
        }
        memo[k][n] = res;
        return res;
    }
}
