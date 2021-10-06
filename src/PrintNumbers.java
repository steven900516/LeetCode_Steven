import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2021-10-06
 */
public class PrintNumbers {

    int cnt = 0;

    public int[] printNumbers(int n) {
        int end = (int)Math.pow(10, n) - 1;
        int[] res = new int[end];
        for(int i = 0; i < end; i++)
            res[i] = i + 1;
        return res;
    }


    public int[] printNumbers2(int n) {
        int max = (int) (Math.pow(10, n) - 1);
        int[] res = new int[max];
        backtrack(res, new StringBuilder(), n, 0);
        return res;
    }

    public void backtrack(int[] res, StringBuilder sb, int n, int digit) {
        if (digit == n) {
            int num = Integer.parseInt(sb.toString());
            if (num != 0) {
                res[cnt++] = num;
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            sb.append(i);
            backtrack(res, sb, n, digit + 1);
            sb.deleteCharAt(digit);
        }
    }

}
