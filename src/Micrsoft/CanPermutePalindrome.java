package Micrsoft;

import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2022-02-14
 */
public class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> dic = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            dic.put(s.charAt(i),dic.getOrDefault(s.charAt(i),0) + 1);
        }
        int odd = 0;
        for (int val : dic.values()){
            if(val % 2 != 0){
                odd++;
                if(odd > 1) return false;
            }
        }
        return true;
    }
}
