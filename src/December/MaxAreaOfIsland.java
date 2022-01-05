package December;

/**
 * @author Steven0516
 * @create 2022-01-03
 */
public class MaxAreaOfIsland {
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea,dfs(i,j,grid));
                }
            }
        }
        return maxArea;
    }


    public int dfs(int i,int j,int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int left = dfs(i,j - 1,grid);
        int right = dfs(i,j + 1,grid);
        int up = dfs(i - 1,j,grid);
        int down = dfs(i + 1,j,grid);
        return 1 + left + right + up + down;
    }
}
