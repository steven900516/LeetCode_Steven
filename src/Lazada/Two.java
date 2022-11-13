package Lazada;

import java.util.Scanner;

public class Two {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        String a1 = Integer.valueOf(a,2).toString();
        String b1 = Integer.valueOf(b,2).toString();

        int c1 = Integer.parseInt(a1) + Integer.parseInt(b1);

        System.out.println(Integer.toBinaryString(c1));
    }
}
