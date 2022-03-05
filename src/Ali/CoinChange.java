package Ali;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2022-03-03
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for (int i = 0; i <= amount; i++) {
            for(int coin: coins){
                if(i - coin < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i],dp[i - coin]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
