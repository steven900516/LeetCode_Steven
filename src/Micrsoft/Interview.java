package Micrsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Steven0516
 * @create 2021-12-29
 */
public class Interview {
    HashSet<String> res = new HashSet<>();
    ArrayList<String> list = new ArrayList<>();
    public HashSet test(String s){
        char[] tmp = s.toCharArray();
        backTrack(new StringBuilder(), tmp, 0);
        return res;
    }

    public void backTrack(StringBuilder sb,char[] tmp,int index){
        if(sb.length() == tmp.length){
            res.add(sb.toString());
            return;
        }

        for(int i = index;i < tmp.length;i++){
            sb.append(tmp[i]);
            swap(tmp,i,index);
            backTrack(sb,tmp,i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }




    public static void main(String[] args) {
        Interview main = new Interview();
        String s = "qqe";
        System.out.println(main.test(s));
    }

    public static void swap(char[] tmp,int i,int k){
        char ch = tmp[i];
        tmp[i] = tmp[k];
        tmp[i] = ch;
    }
}
