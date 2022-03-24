package Ali;

import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2022-02-25
 */

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0;
        int ans = 0;
        //abba
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if(map.containsKey(tmp)){
                start = Math.max(map.get(tmp) + 1,start);
            }
            map.put(tmp,i);
            ans = Math.max(ans,i - start + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(problem3.lengthOfLongestSubstring("bbbbb"));
        System.out.println(problem3.lengthOfLongestSubstring("pwwkew"));
    }
}
