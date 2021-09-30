/**
 * @author Steven0516
 * @create 2021-09-30
 */





//捡绳子
    //动态规划
public class CuttingRope {
    public int cuttingRope(int n) {

        //dp数组表达的是长度为n的最大乘积为dp[n]
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 3;i <= n ;i ++){
            for(int j = 2;j < i;j++){
                dp[i] = Math.max(dp[i],Math.max(j * (i - j),dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
