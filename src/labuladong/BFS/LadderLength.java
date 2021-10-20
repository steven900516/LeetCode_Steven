package labuladong.BFS;

import java.util.*;

/**
 * @author Steven0516
 * @create 2021-10-20
 */
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int step = 0;
        q.add(beginWord);
        visited.add(beginWord);
        while(!q.isEmpty()){

            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if(cur.equals(endWord)){
                    return step;
                }
                List<String> children = children(cur, wordList);
                System.out.println(children);
                for (int j = 0; j < children.size(); j++) {
                    String tmp = children.get(j);
                    if(!visited.contains(tmp)){
                        q.add(tmp);
                        visited.add(tmp);
                    }
                }
            }
            step++;
        }

        return 0;
    }


    List<String> children(String cur,List<String> wordList){
        LinkedList<String> children = new LinkedList<>();
        for(String word : wordList){
            int dif = 0;
            for (int i = 0; i < word.length(); i++) {
                if(word.charAt(i) != cur.charAt(i)) dif++;
                if(dif > 1) break;
            }
            if(dif == 1) children.add(word);
        }

        return children;
    }

    public static void main(String[] args) {
        LadderLength ladderLength = new LadderLength();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("hot");
        strings.add("dot");
        strings.add("dog");
        strings.add("lot");
        strings.add("log");
        strings.add("cog");
        System.out.println(ladderLength.children("hit", strings));
    }
}
