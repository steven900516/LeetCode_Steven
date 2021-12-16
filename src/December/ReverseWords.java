package December;

import java.util.LinkedList;

/**
 * @author Steven0516
 * @create 2021-12-16
 */
public class ReverseWords {
    public String reverseWords(String s) {
        int left = 0,right = 0;
        char[] chars = s.toCharArray();
        LinkedList<String> set = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while(right < s.length()){
            left = right;
            while(left < s.length() && chars[left] == ' '){
                left++;
            }
            right = left;
            while(right < s.length() && chars[right] != ' ' ){
                right++;
            }
            if(left == right && left == s.length())  break;
            set.add(s.substring(left,right));
        }
        for(int i = set.size() - 1;i >= 0;i--){
            sb.append(set.get(i) + (i == 0 ? "" : " "));
        }
        return sb.toString();
    }
}
