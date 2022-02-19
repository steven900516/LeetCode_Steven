package Micrsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-02-18
 */
public class Permutation2 {
    List<String> ans = new ArrayList<>();
    boolean used[];
    public String[] permutation(String S) {
        if(S.length() == 0){
            return new String[0];
        }
        used = new boolean[S.length()];
        backTrack(S,0,new StringBuilder());
        String[] res = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private void backTrack(String s, int index, StringBuilder sb) {
        if(sb.length() == s.length()){
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if(used[i]) continue;
            used[i] = true;
            sb.append(s.charAt(i));
            backTrack(s,i + 1,sb);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}
