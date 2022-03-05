package Ali;

import java.util.Scanner;

/**
 * @author Steven0516
 * @create 2022-03-04
 */
public class Pick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int max = Integer.MIN_VALUE;
        int ansX = 0;
        int ansY = 0;
        for (int i = 1; i <= A ; i++) {
            for (int j = 1; j <= B ; j++) {
                if(i == j * a / b && i * j > max){
                    max = i * j;
                    ansX = i;
                    ansY = j;
                }
            }
        }

        System.out.println(max == Integer.MIN_VALUE ? "0 0" : ansX + " " + ansY);
    }
}
