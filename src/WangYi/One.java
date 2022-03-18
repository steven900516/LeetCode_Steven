package WangYi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Steven0516
 * @create 2022-03-17
 */
public class One {
    static char[][] tmp = null;
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            char[][] borad = new char[3][3];
            ArrayList<int[][]> part = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                String s = scanner.next();
                for (int k = 0; k < s.length(); k++) {
                    borad[j][k] = s.charAt(k);
                }
            }
            scanner.nextLine();
            for (int c = 0; c < 3; c++) {
                int[][] relation = new int[3][2];
                String next = scanner.nextLine();
                String[] in = next.split(" ");
                for (int j = 0; j < in.length; j++) {
                    if(j % 2 == 0){
                        relation[j / 2][0] = Integer.parseInt(in[j]);
                    }else{
                        relation[j / 2][1] = Integer.parseInt(in[j]);
                    }
                }
                part.add(relation);
            }
            solution(borad,part);
        }

    }

    private static void solution(char[][] borad, ArrayList<int[][]> part) {
        count = 0;
        helper(borad,part);
        if(count == 0){
            System.out.println("No");
        }else if(count == 1){
            System.out.println("Unique");
            for (int i = 0; i < 3; i++) {
                System.out.println(tmp[i]);
            }
        }else if(count > 1){
            System.out.println("Multiple");
        }
    }

    private static boolean helper(char[][] borad, ArrayList<int[][]> part) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(borad[i][j] != '*'){
                    continue;
                }
                for (char k = '1'; k <= '3'; k++) {
                    if(judge(borad,part,i,j,k)){
                        borad[i][j] = k;
                        if(helper(borad, part)){
                            if(tmp == null){
                                tmp = new char[3][3];
                                for (int l = 0; l < 3; l++) {
                                    for (int m = 0; m < 3; m++) {
                                        tmp[l][m] = borad[l][m];
                                    }
                                }
                            }
                            count++;
                        }
                        borad[i][j] = '*';
                    }
                }
                return false;
            }
        }
        return true;
    }

    public static boolean judge(char[][] borad, ArrayList<int[][]> part,int i,int j,char q){
        for (int m = 0;m < 3;m++){
            if(m == j) continue;
            if(borad[i][m] == q){
                return false;
            }
        }

        for (int m = 0;m < 3;m++){
            if(m == i) continue;
            if(borad[m][j] == q){
                return false;
            }
        }
        int index = 0;
        for (int k = 0; k < part.size(); k++) {
            int[][] ints = part.get(k);
            for (int l = 0; l < ints.length; l++) {
                if(ints[l][0] == i && ints[l][1] == j){
                    index = k;
                    break;
                }
            }
        }
        int[][] ints = part.get(index);
        for (int k = 0; k < ints.length; k++) {
            if(ints[k][0] != i && ints[k][1] != j && borad[ints[k][0]][ints[k][1]] == q){
                return false;
            }
        }
        return true;
    }
}
