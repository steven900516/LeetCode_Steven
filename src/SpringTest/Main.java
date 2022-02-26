package SpringTest;

/**
 * @author Steven0516
 * @create 2022-02-26
 */
public class Main {
    public static String caculate(String S){
        if(S.length() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int n = S.length();
        for (int i = 0; i < n; i++) {
            int j = i;
            while(j < n - 1 && S.charAt(i) == S.charAt(j + 1)){
                j++;
            }
            sb.append(S.charAt(i)).append("_").append(j - i + 1).append("_");
            i = j;
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}
