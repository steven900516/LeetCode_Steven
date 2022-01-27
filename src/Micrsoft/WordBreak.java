package Micrsoft;

import java.util.Arrays;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-01-25
 */
public class WordBreak {
    String s;
    List<String> wordDict;
    boolean ans = false;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        backTrack(new StringBuilder());
        return ans;
    }

    private void backTrack(StringBuilder sb) {
        if(sb.length() > s.length()){
            return;
        }
        if(sb.toString().equals(s)){
            ans = true;
            return;
        }

        for (int i = 0; i < wordDict.size(); i++) {
            if(sb.length() + wordDict.get(i).length() > s.length()) continue;
            if(wordDict.get(i).length() > 0 && s.charAt(sb.length()) != wordDict.get(i).charAt(0)){
                continue;
            }
            sb.append(wordDict.get(i));
            backTrack(sb);
            sb.delete(sb.length() - wordDict.get(i).length(),sb.length());
        }
    }


    public boolean wordBreak2(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 0; i < length; i++) {
            if (!dp[i]) {
                continue;
            }
            for (String word : wordDict) {
                if (word.length() + i <= s.length() && s.startsWith(word, i)) {
                    dp[i + word.length()] = true;
                }
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        System.out.println(s1.startsWith("code",4));
    }
}
