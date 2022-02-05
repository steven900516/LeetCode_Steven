package Micrsoft;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Steven0516
 * @create 2022-02-04
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        //Compare 当前减后 大于 0时需要交换顺序  ，小于不用
        //假如 x为 3  y为30   330 > 303  所以需要交换顺序  x = 30,y = 3
        Arrays.sort(str, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : str)
            res.append(s);
        return res.toString();

    }
}
