package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-02-15
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n < 2){
            return s;
        }

        boolean[][] dp = new boolean[n][n];

        for(int i = 0;i < n;i++){
            dp[i][i] = true;
        }
        int left = 0;
        int right = 1;
        int len = 1;

        //从j到i是否为回文字符串
        for(int i = 1;i < n;i++){
            for(int j = 0;j < i;j++){
                if(s.charAt(j) == s.charAt(i)){
                    if(i - j <= 2){
                        dp[j][i] = true;
                    }else{
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }else{
                    dp[j][i] = false;
                }

                if(i - j + 1 > len && dp[j][i]){
                    len = i - j + 1;
                    left = j;
                    right = i + 1;
                }
            }
        }

        return s.substring(left,right);
    }
}
