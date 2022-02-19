package Micrsoft;

import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2022-02-18
 */
public class OneEditAway {
    public boolean oneEditAway(String first, String second) {
        int lf = first.length(), ls = second.length();
        if (lf > ls)
            return oneEditAway(second, first);
        if (ls - lf > 1)
            return false;
        if (lf == ls) {
            int count = 0;
            for (int i = 0; i < lf; i++) {
                if (first.charAt(i) != second.charAt(i))
                    count += 1;
            }
            return count <= 1;
        }
        int fir = 0;
        int sec = 0;
        while(fir < first.length()){
            if(first.charAt(fir) != second.charAt(fir + sec)){
                sec++;
                if(sec > 1) return false;
            }else{
                fir++;
            }
        }
        return true;
    }
}
