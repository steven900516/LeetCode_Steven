package leetcode;

import java.util.*;

/**
 * @author Steven0516
 * @create 2021-09-11
 */

//第一个只出现一次的字符
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c)); //思路巧妙
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';

    }

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.println(firstUniqChar.firstUniqChar("aabbcc"));
    }
}
