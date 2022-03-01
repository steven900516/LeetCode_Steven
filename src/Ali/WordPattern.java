package Ali;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Steven0516
 * @create 2022-03-01
 */

/*
有一个字符串它的构成是词+空格的组合，如“北京 杭州 杭州 北京 上海”， 要求输入一个匹配模式（简单的以字符来写）， 比如 aabb, 来判断该字符串是否符合该模式， 举个例子：

pattern = “abbac”, str=“北京 杭州 杭州 北京 上海” 返回 ture
pattern = “aacbb”, str=“北京 北京 上海 杭州 北京” 返回 false
pattern = “baabcc”, str=“北京 杭州 杭州 北京 上海 上海” 返回 ture
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {

        String[] words = str.split(" ");
        HashMap<String, LinkedList<Integer>> map = new HashMap<String, LinkedList<Integer>>();
        for (int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i])){
                LinkedList<Integer> list = map.get(words[i]);
                list.add(i);
                map.put(words[i],list);
            }else{
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(words[i],list);
            }
        }

        for(Map.Entry<String, LinkedList<Integer>> eve :map.entrySet()){
            LinkedList<Integer> list = eve.getValue();
            char c = pattern.charAt(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                if(pattern.charAt(list.get(i)) != c){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("baabcc", "北京 杭州 杭州 北京 上海 上海"));

    }

}
