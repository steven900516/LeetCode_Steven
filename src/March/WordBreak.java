package March;

import java.util.List;

/**
 * @author Steven0516
 * @create 2022-03-07
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for(int i = 1;i <= n;i++){
            for(int j = 0;j < i;j++){
                if(wordDict.contains(s.substring(j,i)) && dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
