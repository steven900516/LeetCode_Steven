package labuladong.Dynamic;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Steven0516
 * @create 2021-10-30
 */
public class FindCheapestPrice {
    int INF = 1000007;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return dp(n, flights, src, dst, k);
    }

    private int dp(int n, int[][] flights, int src, int dst, int K) {
        // dp[i][k]表示从i点到dst走k步的最少价格
        // dp[i][k]=min(dp[i_next][k-1] + g[i][j])
        int[][] dp = new int[n][K+2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[dst][0] = 0;
        for (int k = 1; k <= K + 1; k++) {
            for (int[] flight : flights) {
                dp[flight[0]][k] = Math.min(dp[flight[0]][k], dp[flight[1]][k - 1] + flight[2]);
            }
        }

        int ans = IntStream.of(dp[src]).min().getAsInt();

        return ans >= INF ? -1 : ans;


    }
}
