package SpringTest.First;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Steven0516
 * @create 2022-01-12
 */
public class SmartEdit {
    String[] strings;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void smartEdit() throws IOException {
        Integer count = Integer.parseInt(br.readLine());
        strings = new String[count];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = br.readLine();
        }
        for (int i = 0; i < strings.length; i++) {
            edit(strings,i);
        }

    }

    public void edit(String[] strings,int index){
        String input = strings[index];
        StringBuilder sb = new StringBuilder(input);
        int right = 0;
        while(right < sb.length()){
            if(right >= 2 && sb.charAt(right) == sb.charAt(right - 1) && sb.charAt(right) == sb.charAt(right - 2)){
                sb.deleteCharAt(right);
                continue;
            }
            if(right >= 3 && sb.charAt(right) == sb.charAt(right - 1) && sb.charAt(right - 2) == sb.charAt(right - 3)){
                sb.deleteCharAt(right);
                continue;
            }
            right++;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        SmartEdit smartEdit = new SmartEdit();
        smartEdit.smartEdit();
    }
}
