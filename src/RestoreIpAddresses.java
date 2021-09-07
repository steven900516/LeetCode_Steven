import java.util.ArrayList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-09-07
 */
public class RestoreIpAddresses {
    ArrayList<String> tot = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backTrack(0,1,s,new StringBuffer());
        return tot;
    }

    private void backTrack(int left,int right,String s,StringBuffer combine){
        if(right == s.length()){
            tot.add(combine.toString());
            return;
        }

        String sub = s.substring(left,right);
        for (int i = 0; i < s.length(); i++) {

        }


    }
}
