package labuladong.Dynamic;

/**
 * @author Steven0516
 * @create 2021-10-25
 */
public class Knapspack {
    /*
       0,1 背包问题
       val为每商品的价值
       wt为每商品的重量
     */


    int knapspack(int W,int N,int[] wt,int[] val){
        //dp含义为： 对于当前i个物品，当背包容量为w时，可以装的最大价值是dp[i][w]

        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if(w - wt[i - 1] < 0){
                    dp[i][w - 1] = dp[i - 1][w];
                }else{
                    //装入背包
                    dp[i][w] = Math.max(dp[i - 1][w - wt[i - 1]] + val[i - 1],dp[i  - 1][w]);
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        String s = new String(new char[]{'a', 'b', 'c', 'd'}, 0, 2);
        System.out.println(s);
    }
}
