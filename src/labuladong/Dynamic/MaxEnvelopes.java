package labuladong.Dynamic;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2021-10-26
 */
public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]);


        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;



    }
}
