/**
 * @author Steven0516
 * @create 2021-09-09
 */
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        String head = s.substring(0, n);
        String tail = s.substring(n, s.length());
        s = tail + head;
        return s;
    }
}
