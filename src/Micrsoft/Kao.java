package Micrsoft;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Steven0516
 * @create 2021-12-29
 */
public class Kao {
    ArrayList<String> list = new ArrayList<>();

    public String[] permutation(String S) {
        char[] cs = S.toCharArray();
        DFS(new StringBuilder(), cs, new HashSet<>(), S.length());
        String[] strings = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strings[i] = list.get(i);
        }
        return strings;
    }

    public void DFS(StringBuilder s, char[] cs, HashSet<Character> set, int n) {
        if (s.length() == n) {
            list.add(s.toString());
        } else {
            for (int i = 0; i < n; i++) {
                if (!set.contains(cs[i])) {
                    set.add(cs[i]);
                    s.append(cs[i]);
                    DFS(s, cs, set, n);
                    set.remove(cs[i]);
                    s.deleteCharAt(s.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Kao kao = new Kao();
        for(String s: kao.permutation("qqe")){
            System.out.println(s);
        }

    }
}
