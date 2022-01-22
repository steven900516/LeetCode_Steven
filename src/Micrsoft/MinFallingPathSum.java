package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-01-22
 */
public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int sm = Integer.MAX_VALUE;



        for(int i = 0;i < col;i++){
            dp[0][i] = matrix[0][i];
            if(matrix[0][i] < sm){
                sm = matrix[0][i];
            }
        }
        if(row == 1){
            return sm;
        }

        sm = Integer.MAX_VALUE;

        if(col == 1){
            int sum = 0;
            for(int i = 0;i < row;i++){
                sum += matrix[i][0];
            }
            return sum;
        }

        for(int i = 1;i < row;i++ ){
            for(int j = 0;j < col;j ++){
                int cur = matrix[i][j];
                if(j == 0){
                    int t2 = cur + dp[i - 1][j];
                    int t3 = cur + dp[i - 1][j + 1];
                    dp[i][j] = Math.min(t2,t3);
                }else if(j == col - 1){
                    int t1 = cur + dp[i - 1][j - 1];
                    int t2 = cur + dp[i - 1][j];
                    dp[i][j] = Math.min(t1,t2);
                }else{
                    int r1 = cur + dp[i - 1][j - 1];
                    int r2 = cur + dp[i - 1][j];
                    int r3 = cur + dp[i - 1][j + 1];
                    dp[i][j] = min(r1,r2,r3);
                }

            }
        }
        for(int i = 0;i < col;i++){
            if(dp[row - 1][i] < sm){
                sm = dp[row - 1][i];
            }
        }
        return sm;

    }

    int min(int a,int b,int c){
        return Math.min(Math.min(a,b),c);
    }
}
