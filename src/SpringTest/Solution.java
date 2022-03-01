package SpringTest;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2022-02-27
 */
public class Solution {

    public static int solution(int[] A,int M){
        if(A.length <= 1) return 0;
        int[] dp = new int[A.length];
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            int res = 1;
            for (int j = 0; j < i; j++) {
                if(Math.abs(A[i] - A[j]) % M == 0){
                    res++;
                }
            }
            ans = Math.max(res,ans);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 1, 11, 8, 4, 10}, 8));
    }
}
