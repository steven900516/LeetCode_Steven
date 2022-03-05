package Ali;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Steven0516
 * @create 2022-03-04
 */
public class Main {
    public static void main(String[] args) {
        int ans = 0;
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        for (int i = 0; i < rows; i++) {
            int A = in.nextInt();
            int B = in.nextInt();
            int each = 1;
            for (int j = 0; j < B + 1; j++) {
                ans += each;
                each += A - 2;
            }
        }

        System.out.println(ans);

    }
}
