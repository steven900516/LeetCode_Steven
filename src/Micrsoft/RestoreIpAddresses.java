package Micrsoft;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-01-06
 */
public class RestoreIpAddresses {
    List<String> res = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        char[] sArray = s.toCharArray();
        backTrack(s,0,new StringBuilder(),0);
        return res;
    }

    private void backTrack(String s, int index, StringBuilder sb,int count) {
        if(count > 4) return;
        if(index == s.length() && count == 4){
            res.add(sb.toString());
            return;
        }

        for(int i = index;i <= s.length();i++){
            String tmp = s.substring(index,i);
            if(isValid(tmp)){
                int start = sb.length();
                if(i == s.length()){
                    sb.append(tmp);
                }else{
                    sb.append(tmp + ".");
                }
                int end = sb.length();
                count++;
                backTrack(s,i,sb,count);
                sb.delete(start,end);
                count--;
            }
        }
    }

    public boolean isValid(String s){
        if(s.length() == 0) return false;
        if(s.length() == 1) return true;
        if(s.length() > 4) return false;
        if(s.length() >= 2 && s.charAt(0) == '0') return false;
        Integer turn = Integer.parseInt(s);
        if(turn >= 10 && turn <= 255) return true;
        return false;
    }
}
