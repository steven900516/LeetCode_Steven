package Lazada;

import java.util.ArrayList;
import java.util.Scanner;

public class One {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()){
            list.add(sc.nextInt());
        }
        int max = Integer.MIN_VALUE;
        int tmpMax = 1,tmpMin = 1;
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (num < 0){
                int tmp = tmpMax;
                tmpMax = tmpMin;
                tmpMin = tmp;
            }
            tmpMax = Math.max(tmpMax * num,num);
            tmpMin = Math.min(tmpMin * num,num);
            max = Math.max(max,tmpMax);
        }

        System.out.println(max);
    }
}
