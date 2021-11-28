package company;

/**
 * @author Steven0516
 * @create 2021-11-28
 */
public class CompareVersion {
    public int compareVersion(String v1, String v2) {
        int i = 0;
        int j = 0;
        int m = v1.length();
        int n = v2.length();
        while(i < m || j < n){
            int num1 = 0;
            int num2 = 0;
            while(i < m && v1.charAt(i) != '.'){
                num1 = num1 * 10 + v1.charAt(i++) - '0';
            }
            while(j < n && v2.charAt(j) != '.'){
                num2 = num2 * 10 + v2.charAt(j++) - '0';
            }

            if(num1 > num2){
                return 1;
            }else if(num1 < num2){
                return -1;
            }
        }

        return 0;
    }
}
