package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-02-06
 */
public class CompressString {

    public String compressString(String S) {
        int i = 0;
        int j = 0;
        int n = S.length();
        StringBuilder sb = new StringBuilder();
        while(i < n){
            while(j < n && S.charAt(i) == S.charAt(j)){
                j++;
            }
            sb.append(S.charAt(i)).append(j - i);
            i = j;
        }
        return sb.length() >= n  ? S : sb.toString();
    }
}
