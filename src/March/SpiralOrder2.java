package March;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-03-22
 */
public class SpiralOrder2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int lToR = 0;
        int tToD = 0;
        int rToL = matrix[0].length - 1;
        int dToUp = matrix.length - 1;

        while(true){
            for (int i = lToR; i <= rToL; i++) {
                res.add(matrix[tToD][i]);
            }
            if(++tToD > dToUp) break;
            for (int i = tToD; i <= dToUp; i++) {
                res.add(matrix[i][rToL]);
            }
            if(--rToL < lToR) break;
            for (int i = rToL; i >= lToR ; i--) {
                res.add(matrix[dToUp][i]);
            }
            if(--dToUp < tToD) break;
            for (int i = dToUp; i >= tToD ; i--) {
                res.add(matrix[i][lToR]);
            }
            if(++lToR > rToL) break;
        }

        return res;
    }
}
