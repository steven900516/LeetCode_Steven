package Micrsoft;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Steven0516
 * @create 2022-02-18
 */
public class WordsFrequency {
    Map<String,Integer> bookMap = new HashMap<>();

    public WordsFrequency(String[] book) {
        for(String name : book){
            bookMap.put(name,bookMap.getOrDefault(name,0) + 1);
        }
    }

    public int get(String word) {
        return bookMap.get(word);
    }
}
