package labuladong.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Steven0516
 * @create 2021-10-20
 */
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deads = new HashSet<>();
        for(String s: deadends)  deads.add(s);
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int step = 0;
        q.add("0000");
        visited.add("0000");
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if(deads.contains(cur)) continue;
                if(cur.equals(target)) return step;
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if(!visited.contains(up)){
                        q.add(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur,j);
                    if(!visited.contains(down)){
                        q.add(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }

        return -1;
    }


    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }
    // 将 s[i] 向下拨动一次
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }
}
