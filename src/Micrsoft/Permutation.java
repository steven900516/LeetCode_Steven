package Micrsoft;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-01-12
 */
public class Permutation {
    List<String> res = new LinkedList<>();
    boolean[] used;
    public String[] permutation(String S) {
        used = new boolean[S.length()];
        backTrack(S,new StringBuilder());
        System.out.println(res);
        return null;
    }

    private void backTrack(String s, StringBuilder sb) {
        if(sb.length() == s.length()){
            res.add(sb.toString());
            return;
        }
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if(used[i]) continue;
            if(set.contains(s.charAt(i))) continue;
            used[i] = true;
            set.add(s.charAt(i));
            sb.append(s.charAt(i));
            backTrack(s,sb);
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        permutation.permutation("ab");
    }

}
