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
}
