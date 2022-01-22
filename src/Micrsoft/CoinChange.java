package Micrsoft;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2022-01-22
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,-1);
        for (int i = 0; i <= amount; i++) {
            for (Integer coin: coins) {
                if(i - coin < 0) continue;
                dp[i] = Math.min(dp[i],dp[i - coin] + 1);
            }
        }
        return dp[amount];
    }


    public int coinChange2(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo,666);
        return coinHelper(coins,amount,memo);
    }

    private int coinHelper(int[] coins, int amount,int[] memo) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(memo[amount] != 666) return memo[amount];
        for (int coin : coins){
            int flag = coinHelper(coins, amount - coin, memo);
            if(flag == -1) continue;
            memo[amount] = Math.min(memo[amount],flag + 1);
        }

        return memo[amount];
    }
}
