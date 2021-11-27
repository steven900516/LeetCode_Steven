package game;

/**
 * @author Steven0516
 * @create 2021-11-27
 */
public class MinCost {
    int[] rowCosts;
    int[] colCosts;
    int lastRow;
    int lastCol;
    int res = 0;
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        if(startPos[0] == homePos[0]  && startPos[1] == homePos[1]){
            return res;
        }
        this.rowCosts = rowCosts;
        this.colCosts = colCosts;
        int curRow = startPos[0];
        int curCol = startPos[1];
        lastRow = startPos[0];
        lastCol = startPos[1];


        return dfs(homePos,curRow,curCol);
    }

    public int dfs(int[] homePos,int curRow,int curCol){
        if(curRow == rowCosts.length || curRow < 0 || curCol < 0 || curCol == colCosts.length){
            return 0;
        }
        if(curRow == homePos[0] && curCol == homePos[1]){
            return res;
        }



        if(lastRow == curRow){
            res += colCosts[curCol];
        }else{
            res += rowCosts[curRow];
        }


        int left = dfs(homePos,curRow,curCol - 1);

        int right = dfs(homePos,curRow,curCol + 1);

        int up = dfs(homePos,curRow - 1,curCol);

        int down = dfs(homePos,curRow + 1,curCol);


        lastRow = curRow;
        lastCol = curCol;

        return Math.min(Math.min(left,right),Math.min(up,down));
    }

    public static void main(String[] args) {
        MinCost minCost = new MinCost();
        System.out.println(minCost.minCost(new int[]{0, 1}, new int[]{2, 3}, new int[]{5, 4, 4}, new int[]{8, 2, 6, 7}));
    }
}
