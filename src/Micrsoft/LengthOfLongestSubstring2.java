package Micrsoft;

import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2022-02-21
 */
public class LengthOfLongestSubstring2 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int length = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            char tmp = s.charAt(i);
            if(map.containsKey(tmp)){
                start = map.get(tmp) + 1;
                length = Math.max(length,i - start + 1);
            }

            map.put(tmp,i);
        }

        return length;
    }
}
