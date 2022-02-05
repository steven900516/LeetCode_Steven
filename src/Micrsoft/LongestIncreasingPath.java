package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-02-05
 */
public class LongestIncreasingPath {
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res,dfs(matrix,memo,m,n,i,j));
            }
        }


        return res;
    }

    private int dfs(int[][] matrix, int[][] memo, int m, int n, int i, int j) {
        if(memo[i][j] != 0){
            return memo[i][j];
        }
        ++memo[i][j];
        for (int[] dir : dirs){
            int newRow = i + dir[0];
            int newColumn = j + dir[1];
            if(newRow >= 0 && newRow < m && newColumn >= 0 && newColumn < n && matrix[newRow][newColumn] > matrix[i][j]){
                memo[i][j] = Math.max(memo[i][j],dfs(matrix, memo, m, n, newRow, newColumn) + 1);
            }
        }

        return memo[i][j];
    }
}
