package company;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2021-11-30
 */
public class CoinChange {
    public int coinChange(int[] coins,int amount){
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 0;i < dp.length;i++){
            for(Integer coin: coins){
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }


        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
