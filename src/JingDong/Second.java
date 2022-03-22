package JingDong;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Steven0516
 * @create 2022-03-19
 */
public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] ints = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                ints[m][n] = scanner.nextInt();
//            }
//        }
        Random random = new Random();
        System.out.println(random.nextInt(m + n));
    }
}
