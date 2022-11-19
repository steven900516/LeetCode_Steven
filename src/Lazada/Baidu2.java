package Lazada;

import java.util.Scanner;

public class Baidu2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();

        for (int i = 0; i < total; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }

            int eve = solution(nums);
            System.out.println(eve);
            System.out.println("---");
        }

    }

    private static int solution(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[n];
            for (int j = 0; i + j < n; j++) {
                used[i + j] = true;
                if (judge(used,i,j,nums[i + j])){
                    sum++;
                }
            }
        }
        return sum;
    }

    private static boolean judge(boolean[] used, int i, int j, int num) {

        for (int k = 0; k <= num - 1 && (num - 1) < used.length ; k++) {
            if (!used[k]){
                return false;
            }
        }
        System.out.println("i : " + i + ",j : " + (i + j));

        return true;
    }
}
