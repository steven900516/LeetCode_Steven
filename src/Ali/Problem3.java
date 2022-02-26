package Ali;

import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2022-02-25
 */

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int length = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if(map.containsKey(tmp)){
                start = Math.max(start,map.get(tmp) + 1);
            }
            length = Math.max(i - start + 1,length);
            map.put(tmp,i);
        }
        return length;

    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(problem3.lengthOfLongestSubstring("bbbbb"));
        System.out.println(problem3.lengthOfLongestSubstring("pwwkew"));
    }
}
