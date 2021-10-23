package labuladong.Dynamic;

/**
 * @author Steven0516
 * @create 2021-10-23
 */
public class MinDistance {
    public int minDistance(String w1, String w2) {
        return dp(w1.length() - 1,w2.length() - 1,w1,w2);
    }



    int dp(int i,int j,String w1,String w2){
        if(i == -1)  return j + 1;
        if(j == -1)  return i + 1;
        if(w1.charAt(i) == w2.charAt(j)){
            return dp(i - 1,j - 1,w1,w2);
        }else{
            int r1 = dp(i,j - 1,w1,w2) + 1;
            int r2 = dp(i - 1,j,w1,w2) + 1;;
            int r3 = Math.min(r1,r2);
            return Math.min(r3,dp(i - 1,j - 1,w1,w2) + 1);
        }

    }


    public int minDistance2(String w1, String w2) {
        int[][] dp = new int[w1.length() + 1][w2.length() + 1];

        for (int i = 1; i <= w1.length() ; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= w2.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= w1.length() ; i++) {
            for (int j = 1; j <= w2.length(); j++) {
                if(w1.charAt(i) == w2.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = min(dp[i - 1][j] + 1,dp[i][j - 1] + 1,dp[i - 1][j - 1]);
                }
            }
        }


        return dp[w1.length()][w2.length()];
    }

    int min(int a,int b,int c){
        return Math.min(Math.min(a,b),c);
    }
}
