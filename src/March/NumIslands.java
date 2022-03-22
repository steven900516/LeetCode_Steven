package March;

/**
 * @author Steven0516
 * @create 2022-03-21
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    dfs(i,j,grid);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j, char[][] grid) {
        if(i < 0 || i >= grid.length  || j < 0 || j >= grid[0].length|| grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0';
        dfs(i + 1,j,grid);
        dfs(i - 1,j,grid);
        dfs(i,j + 1,grid);
        dfs(i,j - 1 ,grid);
    }
}
