package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-01-08
 */
public class SolveSudoku {
    public void solveSudoku(char[][] board) {
        backTrack(board);
    }

    private boolean backTrack(char[][] board){
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                if(board[row][column] != '.'){
                    continue;
                }
                for (int i = 1; i <= 9 ; i++) {
                    if(isVallid(row,column,board,i)){
                        String s = String.valueOf(i);
                        board[row][column] = s.charAt(0);
                        backTrack(board);
                        board[row][column] = '.';
                    }
                }
                return false;
            }

        }
        return true;
    }


    private boolean isVallid(int row,int column,char[][] board,int count){


        for (int i = 0; i < board.length; i++) {
            String s = String.valueOf(i);
            if(board[row][i] == s.charAt(0)){
                return false;
            }
        }


        for (int i = 0; i < board.length; i++) {
            String s = String.valueOf(i);
            if(board[i][column] == s.charAt(0)){
                return false;
            }
        }


        int nRow = (row / 3) * 3;
        int nRowEnd = nRow + 3;
        int nColumn = (column / 3) * 3;
        int nColumnEnd = nColumn + 3;
        for (int i = nRow; i < nRowEnd; i++) {
            for (int j = nColumn; j < nColumnEnd; j++) {
                String s = String.valueOf(i);
                if(board[i][j] == s.charAt(0)){
                    return false;
                }
            }
        }

        return true;
    }
}
