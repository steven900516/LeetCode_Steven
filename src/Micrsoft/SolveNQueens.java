package Micrsoft;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-01-07
 */
public class SolveNQueens {
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTrack(n, 0, chessboard);
        return res;
    }

    private void backTrack(int n, int row, char[][] chessboard) {
        if(row == n){
            res.add(arrayToList(chessboard));
            return;
        }

        for (int i = 0; i < chessboard[row].length; i++) {
            if(isValid(row, i, n, chessboard)){
                chessboard[row][i] = 'Q';
                backTrack(n,row + 1,chessboard);
                chessboard[row][i] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List arrayToList(char[][] chessboard) {
        LinkedList<String> tmp = new LinkedList<>();
        for (char[] each: chessboard){
            tmp.add(String.valueOf(each));
        }
        return tmp;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i) {
            System.out.println(i);
        }
    }
}
