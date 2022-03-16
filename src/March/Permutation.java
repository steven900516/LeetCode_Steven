package March;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Steven0516
 * @create 2022-03-14
 */
public  class Permutation {
    ArrayList<String> res = new ArrayList<>();
    boolean used[];
    public String[] permutation(String s) {
        if(s.length() == 0){
            return new String[]{};
        }
        used = new boolean[s.length()];
        recur(s,new StringBuilder());
        System.out.println(res);
        String[] ans = res.toArray(new String[]{});
        return ans;
    }

    private void recur(String s, StringBuilder sb) {
        if(sb.length() == s.length()){
            res.add(sb.toString());
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if(!used[i]){
                if(set.contains(tmp)){
                    continue;
                }
                set.add(tmp);
                used[i] = true;
                sb.append(tmp);
                recur(s, sb);
                sb.delete(sb.length() - 1,sb.length());
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        permutation.permutation("aab");
    }
}
