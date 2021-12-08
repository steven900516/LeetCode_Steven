package December;

/**
 * @author Steven0516
 * @create 2021-12-08
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0;i < prices.length;i++){
            min = Math.min(min,prices[i]);
            profit = Math.max(profit,prices[i] - min);
        }

        return profit;
    }
}
