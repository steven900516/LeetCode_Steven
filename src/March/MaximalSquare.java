package March;

/**
 * @author Steven0516
 * @create 2022-03-24
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 0 || n == 0){
            return  0;
        }
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(dp[i - 1][j],Math.min(dp[i - 1][j - 1],dp[i][j - 1])) + 1;
                    }
                    res = Math.max(dp[i][j],res);
                }
            }
        }

        return res * res;
    }
}
