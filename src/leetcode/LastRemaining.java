package leetcode;

import java.util.ArrayList;

/**
 * @author Steven0516
 * @create 2021-09-30
 */

//圆圈中最后剩下的数字
public class LastRemaining {
    public int lastRemaining(int n, int m) {
        int delete = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(i);
        }
        int length = ans.size();
        while(length != 1){
            delete = (delete + m - 1) % length;
            ans.remove(delete);
            length = ans.size();
        }
        return ans.get(0);
    }


    //动态规划
    public int lastRemaining2(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;

    }

    public static void main(String[] args) {
        LastRemaining lastRemaining = new LastRemaining();
        System.out.println(lastRemaining.lastRemaining(5, 3));
    }
}
