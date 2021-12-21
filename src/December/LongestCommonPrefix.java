package December;

/**
 * @author Steven0516
 * @create 2021-12-21
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n == 0) return "";
        String ans = strs[0];
        int i = 1;
        for(i = 1;i < strs.length;i++){
            int j = 0;
            for(;j < ans.length() && j < strs[i].length();j++){
                if(strs[i].charAt(j) != ans.charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0,j);
            if(ans.equals("")){
                return "";
            }
        }
        return ans;
    }
}
