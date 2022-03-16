package MeiTuan;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Steven0516
 * @create 2022-03-12
 */
public class RedBlack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int[] color = new int[n];
//        int[] father = new int[n];
//        for (int i = 0; i < n; i++) {
//            color[i] = scanner.nextInt();
//        }
//
//        for (int i = 0; i < n; i++) {
//            father[i] = scanner.nextInt();
//        }
//
        Random random = new Random();
        random.nextInt(n);
        System.out.println(n);
    }
}


class TreeNode{
    int color;
}
