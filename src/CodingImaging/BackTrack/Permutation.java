package CodingImaging.BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-12-30
 */
public class Permutation {
    List<String> list;
    public String[] permutation(String S) {
        list = new ArrayList<>();
        char[] str = S.toCharArray();
        Arrays.sort(str);
        boolean visited[] = new boolean[str.length];
        dfs(str,visited,new StringBuilder());
        return list.toArray(new String[list.size()]);
    }
    private void dfs(char[] str,boolean visited[],StringBuilder temp){
        if(temp.length()==str.length){
            list.add(temp.toString());
            return;
        }
        for(int i=0;i<str.length;i++){
            if(visited[i]||i!=0&&!visited[i-1]&&str[i]==str[i-1])    continue;
            temp.append(str[i]);
            visited[i] = true;
            dfs(str, visited, temp);
            temp.deleteCharAt(temp.length()-1);
            visited[i] = false;
        }
    }


}
