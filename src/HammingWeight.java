/**
 * @author Steven0516
 * @create 2021-09-27
 */

//二进制中1的个数
public class HammingWeight {


    public int hammingWeight(int n) {
        int res = 0;   //记录1的个数
        while(n != 0) {
            /*
              与操作
              n & 1 = 1,则n的最右位为1
              n & 0 = 0,则n的最右位为0
             */
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
