package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-01-14
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String[] combine = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = combine.length - 1; i >= 0; i--) {
            if(combine[i].equals("")) continue;
            sb.append(combine[i] + " ");
        }
        sb.delete(sb.length() - 1,sb.length());
        return sb.toString();
    }
}
