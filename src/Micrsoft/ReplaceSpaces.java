package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-02-06
 */
public class ReplaceSpaces {
    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if(length < 0)  break;
            char tmp = S.charAt(i);
            if(tmp == ' '){
                sb.append("%20");
            }else{
                sb.append(tmp);
            }
            length--;
        }

        return sb.toString();
    }
}
