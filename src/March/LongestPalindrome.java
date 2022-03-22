package March;

/**
 * @author Steven0516
 * @create 2022-03-20
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n < 2){
            return s;
        }

        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int start = 0;
        int length = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)){
                    if(i - j < 2){
                        dp[j][i] = true;
                    }else{
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }else {
                    dp[j][i] = false;
                }

                if(i - j + 1 > length && dp[j][i]){
                    length = i - j + 1;
                    start = j;
                }
            }
        }

        return s.substring(start,start + length);
    }
}
