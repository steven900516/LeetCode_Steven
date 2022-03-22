package JingDong;

import java.util.Scanner;

/**
 * @author Steven0516
 * @create 2022-03-19
 */
public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int i = 0;
        int attack = 0;
        int defence = 0;
        int blood = 0;
        while(true){
            if(i == 0){
                blood = b * d - a;
                attack = (int)Math.ceil((double)(b * d - a) / (double)b);  //攻击对方碉堡，还剩多少碉堡
                defence = a - (attack * c);           //被攻击后还多少坦克
            }else{
                blood -= defence;
                attack = (int)Math.ceil((double)(blood) / (double)b);
                if(attack <= 0){
                    defence = defence;
                }else{
                    defence = defence - (attack * c);
                }
            }
            i++;
            if(defence < 0 && attack > 0){
                System.out.println(-1);
                return;
            }
            if(attack <= 0 && defence >= 0){
                System.out.println(i);
                return;
            }
        }


    }
}
