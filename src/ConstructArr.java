/**
 * @author Steven0516
 * @create 2021-09-29
 */

//构建乘机数组
public class ConstructArr {
    public int[] constructArr(int[] a) {
        int[] ans = new int[a.length];


        //计算第i个数之前的乘机
        for (int i = 0, p = 1; i < a.length; i++) {
            ans[i] = p;
            p *= a[i];
        }


        //计算第i个数之后的乘机
        for (int i = a.length - 1, p = 1; i >= 0; i--) {
            ans[i] *= p;
            p *= a[i];
        }
        return ans;
    }
}
