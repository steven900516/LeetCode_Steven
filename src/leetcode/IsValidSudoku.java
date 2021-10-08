package leetcode;

import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2021-08-07
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int times = 0;
        int index = 0;
        int l = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(count.containsKey(board[i][j])){
                    return false;
                }
                if(Character.isDigit(board[i][j])){
                    count.put(board[i][j],1);
                }
            }
            count.clear();
        }
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(count.containsKey(board[j][i])){
                    return false;
                }
                if(Character.isDigit(board[j][i])){
                    count.put(board[j][i],1);
                }
            }
            count.clear();
        }

        while(true){
            if(times % 3==0 && times !=0){
                l++;
            }
            if(times % 3 == 0){
                index = 0;
            }
            for (int i = index  * 3; i <  3 * (index + 1); i++) {
                for (int j = l * 3; j < (l + 1) * 3; j++) {
                    if(count.containsKey(board[i][j])){
                        return false;
                    }
                    if(Character.isDigit(board[i][j])){
                        count.put(board[i][j],1);
                    }
                }
            }
            count.clear();
            index++;
            times++;
            if(times == board.length){
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] chars = new char[9][9];
        chars[0][6] = '5';
        chars[2][8] = '3';
        chars[3][1] = '2';
        chars[3][3] = '7';
        chars[4][0] = '8';
        chars[4][1] = '3';
        chars[4][2] = '6';
        chars[4][3] = '5';
        chars[4][8] = '1';
        chars[5][5] = '1';
        chars[6][0] = '2';
        chars[6][8] = '5';
        chars[7][8] = '7';
        chars[8][3] = '4';
        chars[8][7] = '7';
        IsValidSudoku isValidSudoku = new IsValidSudoku();
        System.out.println(isValidSudoku.isValidSudoku(chars)); //
    }
}
