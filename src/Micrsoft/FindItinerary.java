package Micrsoft;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-01-07
 */
public class FindItinerary {

    List<List<String>> res = new LinkedList<>();
    boolean used[];
    public List<String> findItinerary(List<List<String>> tickets) {
        used = new boolean[tickets.size()];
        LinkedList<String> path = new LinkedList<>();
        backTrack(tickets,path);
        return null;
    }

    private void backTrack(List<List<String>> tickets,LinkedList<String> path) {
        if(res.size() == tickets.size() + 1){
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < tickets.size(); i++) {

        }
    }
}
