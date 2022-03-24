package March;

/**
 * @author Steven0516
 * @create 2022-03-24
 */
public class NumDecodings {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            char tmp = s.charAt(i - 1);
            if(tmp != '0'){
                dp[i] += dp[i - 1];
            }
            if(i > 1 && ((s.charAt(i - 2) - '0') * 10 + tmp - '0') <= 26 && s.charAt(i - 2) != '0'){
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
