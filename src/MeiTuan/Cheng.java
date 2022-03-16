package MeiTuan;

import java.util.*;

/**
 * @author Steven0516
 * @create 2022-03-12
 */
public class Cheng {
    static ArrayList<List<Integer>> res = new ArrayList<>();
    static void solution(int[] nums){
        int n = nums.length;

        for (int i = 1; i <= n; i++) {
            recur(i,nums);
        }
        int count = 0;

        for (int i = 0;i < res.size();i++){
            List<Integer> list = res.get(i);
            int flag = 1;
            for (int j = 0; j < list.size(); j++) {
                flag *= list.get(j);
            }
            if(flag > 0){
                count++;
            }
        }
        System.out.println(count);
    }

    private static void recur(int count, int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            if(i + count > nums.length)  break;
            for (int j = 0; j < count; j++) {
                if(i + j < nums.length){
                    list.add(nums[i + j]);
                }
            }
            res.add(list);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        solution(nums);
    }
}
