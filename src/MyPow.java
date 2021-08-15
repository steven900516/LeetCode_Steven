/**
 * @author Steven0516
 * @create 2021-08-13
 */
public class MyPow {
    //增加注释


    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }


    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(2, 3));
    }
}
