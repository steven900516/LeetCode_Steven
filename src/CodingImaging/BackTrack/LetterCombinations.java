package CodingImaging.BackTrack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-12-27
 */
public class LetterCombinations {
    HashMap<Character,String> phone = new HashMap<>();
    List<String> res = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return res;
        }
        phone.put('2',"abc");
        phone.put('3',"def");
        phone.put('4',"ghi");
        phone.put('5',"jkl");
        phone.put('6',"mno");
        phone.put('7',"pqrs");
        phone.put('8',"tuv");
        phone.put('9',"wxyz");
        StringBuilder sb = new StringBuilder();
        backTrack(digits,sb,0);
        return res;
    }

    private void backTrack(String digits, StringBuilder sb,int index) {
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }

        for (int i = index; i < digits.length(); i++) {
            char c = digits.charAt(i);
            String ch = phone.get(c);
            for(int j = 0;j < ch.length();j++){
                char cc = ch.charAt(j);
                sb.append(cc);
                backTrack(digits,sb,i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
