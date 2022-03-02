package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-03-02
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(board[i][j] == word.charAt(0)){
                    if(judge(board,i,j,word,0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean judge(char[][] board, int i, int j, String word, int index) {
        if(index >= word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }

        if(word.charAt(index) != board[i][j]){
            return false;
        }

        char tmp = board[i][j];
        board[i][j] = '.';
        boolean up = judge(board, i - 1, j, word, index + 1);
        boolean down = judge(board, i + 1, j, word, index + 1);
        boolean left = judge(board, i, j - 1, word, index + 1);
        boolean right = judge(board, i, j + 1, word, index + 1);
        board[i][j] = tmp;
        return up || down || left || right;
    }
}
