package Ali;

import java.util.Scanner;

/**
 * @author Steven0516
 * @create 2022-03-03
 */
public class ScannerUtil {

    public void ScanOne(){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
    }

    public void scanMatrix(){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
    }
}
