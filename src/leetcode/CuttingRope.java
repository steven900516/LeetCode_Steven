package leetcode;

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



//  贪心算法并大数取余
    public int cuttingRope2(int n) {

        if(n <= 3){
            return n - 1;
        }
        long res = 1;
        int cnt = n / 3, big = 1000000007;
        int least = n % 3;

        for (int i = 0; i < cnt; i++) {
            res = (res * 3) % big;
        }

        switch (least){
            case 0:
                res = res * 3 % big;
                break;
            case 1:
                res = res * 4 % big;
                break;
            case 2:
                res = res * 6 % big;
                break;
        }
        return (int)res;




    }
}
