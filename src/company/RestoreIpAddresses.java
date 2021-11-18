package company;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-11-18
 */
public class RestoreIpAddresses {
    LinkedList<String> res = new LinkedList<>();
    String s;
    public List<String> restoreIpAddresses(String s) {
        char[] arr = s.toCharArray();
        this.s = s;
        dfs(arr,new StringBuilder(),0,0);
        return res;
    }

    public void dfs(char[] arr,StringBuilder sb,int index,int count){
        if(count > 4) return;
        if(index == s.length() && count == 4){
            res.add(sb.toString());
            return;
        }
        for (int i = index; i <= s.length(); i++) {
            if(isValid(s.substring(index,i))){
                String tmp = s.substring(index,i);
                int start = sb.length();
                int end;
                if(i != s.length()){
                    sb.append(tmp + ".");
                }else{
                    sb.append(tmp);
                }
                count++;
                end = sb.length();
                dfs(arr,sb,i,count);
                count--;
                sb.delete(start,end);
            }
        }
    }

    public boolean isValid(String s){
        if(s.length() == 0) return false;
        if(s.length() > 3) return false;
        if(s.length() == 1 && Integer.parseInt(s) == 0)  return true;
        if(s.length() > 1 && s.charAt(0) == '0')  return false;
        if(Integer.parseInt(s) >= 0  && Integer.parseInt(s) <=255) return true;
        return false;
    }
}
