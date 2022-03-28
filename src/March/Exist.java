package March;

/**
 * @author Steven0516
 * @create 2022-03-28
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)){
                    if (helper(i,j,board,0,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(int i, int j, char[][] board, int index, String word) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j]){
            return false;
        }
        char tmp = word.charAt(index);
        board[i][j] = '.';
        boolean up = helper(i - 1,j,board,index + 1,word);
        boolean down = helper(i + 1,j,board,index + 1,word);
        boolean left = helper(i,j - 1,board,index + 1,word);
        boolean right = helper(i,j + 1,board,index + 1,word);
        board[i][j] = tmp;
        return up || down || left || right;
    }
}
