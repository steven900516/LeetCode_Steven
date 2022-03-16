package MeiTuan;

import java.util.Scanner;

/**
 * @author Steven0516
 * @create 2022-03-12
 */
public class Three {
    static boolean mei[];
    static int ans = 0;
    static boolean cus[];
    public static void solution(int[][] customer){
        helper(0,customer,0);
        System.out.println(ans);
    }

    private static void helper(int count,int[][] customer,int last) {
        if(judge(mei) || last == customer.length - 1){
            ans = Math.max(ans,count);
            return;
        }

        for (int i = 0; i < customer.length; i++) {
            if(!cus[i] && !mei[customer[i][0]] && !mei[customer[i][1]]){
                cus[i] = true;
                mei[customer[i][0]] = true;
                mei[customer[i][1]] = true;
                helper(count + 1,customer,i);
                mei[customer[i][0]] = false;
                mei[customer[i][1]] = false;
                cus[i] = false;
            }else{
                continue;
            }
        }
    }

    private static boolean judge(boolean[] mei){
        for (int i = 1; i < mei.length; i++) {
            if(mei[i] == false){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();   //顾客数量
        int m = scanner.nextInt();   //小美能做多少菜
        int[][] customer = new int[n][2];
        mei = new boolean[m + 1];
        cus = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                customer[i][j] = scanner.nextInt();
            }
        }
        solution(customer);
    }
}
