package leetcode;

/**
 * @author Steven0516
 * @create 2021-09-14
 */


//股票的最大利润
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int index = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < min){
                min = prices[i];
                index = i;
            }
        }
        int max = prices[index];

        for (int i = index; i <prices.length ; i++) {
            if(prices[i] > max){
                max = prices[i];
            }
        }

        if(max <= min) {
            return 0;
        }else{
            return max-min;
        }
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{2,4,1}));
    }
}
