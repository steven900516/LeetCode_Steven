package company;

/**
 * @author Steven0516
 * @create 2021-11-13
 */
public class Island {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    change(grid,i,j);
                    count ++;
                }
            }
        }
        return count;
    }

    private void change(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        if(grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        change(grid,i + 1,j);
        change(grid,i - 1,j);
        change(grid,i,j + 1);
        change(grid,i, j - 1);

    }
}
