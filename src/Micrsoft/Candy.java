package Micrsoft;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2022-02-06
 */
public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int count = left[ratings.length - 1];
        for (int i = n - 2; i >= 0 ; i++) {
            if(ratings[i] > ratings[i + 1]){
                right[i] = right[i + 1] + 1;
            }
            count += Math.max(left[i],right[i]);
        }

        return count;
    }
}
