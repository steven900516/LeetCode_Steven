package Micrsoft;

import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2022-02-15
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            res = Math.max(res,i - left + 1);
            map.put(s.charAt(i),i);
        }
        return res;
    }
}
