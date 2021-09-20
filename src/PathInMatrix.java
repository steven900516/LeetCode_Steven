import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2021-09-20
 */

//矩阵中的路径
public class PathInMatrix {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n  = board[0].length;
        char[] words = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(backTrack(i,j,board,words,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(int i, int j, char[][] board, char[] word,int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k])
            return false;
        if(k == word.length - 1)  return true;
        //将该元素标记为用过的元素，避免递推重复该元素
        board[i][j] = '\0';
        boolean res = backTrack( i + 1, j, board, word,k + 1) || backTrack(i - 1, j, board, word,k + 1) ||
                backTrack( i, j + 1, board, word,k + 1) || backTrack( i , j - 1, board, word,k + 1);
        board[i][j] = word[k];
        return res;
    }

    public static void main(String[] args) {
        int[][] isPath = new int[3][4];

        System.out.println(isPath[1][0]);
    }
}
