package MeiTuan;

import java.util.Scanner;

/**
 * @author Steven0516
 * @create 2022-03-12
 */
public class Lucky {

    public static void solution(int num){
        int count = 0;
        if(num % 11  == 0){
            System.out.println("yes");
            return;
        }
        while(num > 0){
            int fir = num % 10;
            if(fir == 1){
                count++;
            }
            if(count >= 2){
                System.out.println("yes");
                return;
            }
            num = num / 10;
        }

        System.out.println("no");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            solution(nums[i]);
        }
    }
}
