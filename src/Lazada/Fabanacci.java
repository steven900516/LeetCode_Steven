package Lazada;

public class Fabanacci {


    public int solution(int n){
        if (n <= 2){
            return 1;
        }

        return solution(n - 1) + solution(n - 2);
    }


    public int solution2(int n){
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;

        if (n <= 2){
            return dp[n - 1];
        }

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }


        return dp[n];
    }


    // 1,1,2,3,4,7
    public int solution3(int n){
        int preOne = 1;
        int preTwo = 1;

        if (n <= 2) {
            return 1;
        }
        int sum = preOne + preTwo;

        for (int i = 3; i < n; i++) {
            sum += preOne + preTwo;
        }

        return 3;
    }


}
