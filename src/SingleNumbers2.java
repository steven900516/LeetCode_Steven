/**
 * @author Steven0516
 * @create 2021-09-28
 */
public class SingleNumbers2 {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }


    public static void main(String[] args) {
        SingleNumbers2 singleNumbers2 = new SingleNumbers2();
        System.out.println(singleNumbers2.singleNumber(new int[]{3, 4, 3, 3}));
    }
}
