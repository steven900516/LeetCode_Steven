package Ali;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-03-03
 */
public class FindRepeatedDnaSequences {
    LinkedList<String> res = new LinkedList<>();
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String tmp = s.substring(i, i + 10);
            map.put(tmp,map.getOrDefault(tmp,0) + 1);
            if(map.get(map) == 2){
                res.add(tmp);
            }
        }

        return res;
    }
}
