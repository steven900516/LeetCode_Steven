package leetcode;

/**
 * @author Steven0516
 * @create 2021-09-27
 */

//不用加减乘除做加法

public class Add {
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

}
