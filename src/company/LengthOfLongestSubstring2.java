package company;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Steven0516
 * @create 2021-11-23
 */
public class LengthOfLongestSubstring2 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int ans = 0;
        for(int start = 0,end = 0;end < s.length();end++){
            char tmp = s.charAt(end);
            if(map.containsKey(tmp)){
                start = Math.max(map.get(tmp),start);
            }
            ans = Math.max(ans,end - start + 1);
            map.put(tmp,end + 1);
        }
        return ans;
    }
}
