package game;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Steven0516
 * @create 2021-11-13
 */
public class checkAlmostEquivalent {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        HashMap<Character,Integer> w1 = new HashMap<Character,Integer>();
        HashMap<Character,Integer> w2 = new HashMap<Character,Integer>();
        int m = word1.length();
        int n = word2.length();
        for(int i = 0;i < m;i++){
            char tmp = word1.charAt(i);
            if(w1.containsKey(tmp)){
                w1.put(tmp,w1.get(tmp) + 1);
            }else{
                w1.put(word1.charAt(i),0);
            }
        }
        for(int i = 0;i < n;i++){
            char tmp = word2.charAt(i);
            if(w2.containsKey(tmp)){
                w2.put(tmp,w1.get(tmp) + 1);
            }else{
                w2.put(word1.charAt(i),0);
            }
        }

        for (int i = 0; i < m; i++) {
            int w1Count = 0;
            int w2Count = 0;
            if(w1.containsKey(word1.charAt(i))){
                w1Count = w1.get(word1.charAt(i));
            }
            if(w2.containsKey(word1.charAt(i))){
                w2Count = w2.get(word1.charAt(i));
            }
            int sub = Math.abs(w1Count - w2Count);
            if(sub > 3) return false;
        }

        return true;

    }
}
