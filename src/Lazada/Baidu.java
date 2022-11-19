package Lazada;

import java.util.Arrays;
import java.util.Scanner;

public class Baidu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();


        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);

        double sum = 0;
        int index = 0;
        while(k > 0){
            double eve = 0;
            double chu  = 0;
            if(k == 1){
                for (int i = index; i < n; i++) {
                    eve += nums[i];
                }
                chu = eve / (n - index);
            }else {
                chu = nums[index];
            }
            sum += chu;
            index--;
        }

        System.out.println(sum);
    }
}
