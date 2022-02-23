package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-02-23
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if(tmp == ' '){
                sb.append("%20");
            }else{
                sb.append(tmp);
            }
        }
        return sb.toString();
    }
}
