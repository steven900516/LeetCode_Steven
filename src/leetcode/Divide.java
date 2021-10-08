package leetcode;

/**
 * @author Steven0516
 * @create 2021-08-04
 */
public class Divide {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long ldividend = (long)dividend;
        long ldivisor = (long)divisor;

        ldividend = Math.abs(ldividend);
        ldivisor = Math.abs(ldivisor);
        int count = 0;
        while(ldividend >= ldivisor) {
            long lds = ldivisor;
            long temp = 1;
            while((lds << 1) <= ldividend) {
                lds = (lds << 1);
                temp = (temp << 1);
            }
            count += temp;
            ldividend = ldividend - lds;
        }
        return count * sign;
    }

    public static void main(String[] args) {
        Divide divide = new Divide();
        int divide1 = divide.divide(0, 2 );
        System.out.println(divide1);
    }
}
