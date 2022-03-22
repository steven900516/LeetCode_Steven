package March;

/**
 * @author Steven0516
 * @create 2022-03-20
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min,prices[i]);
            ans = Math.max(ans,prices[i] - min);
        }

        return ans < 0 ? 0 : ans;
    }
}
