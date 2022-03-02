package Ali;

/**
 * @author Steven0516
 * @create 2022-03-02
 */

/*
你有一个 n x 3 的网格图 grid ，你需要用 红，黄，绿 三种颜色之一给每一个格子上色，且确保相邻格子颜色不同
（也就是有相同水平边或者垂直边的格子颜色不同）。给你网格图的行数 n 。
请你返回给 grid 涂色的方案数。由于答案可能会非常大，请你返回答案对 10^9 + 7 取余的结果。
https://leetcode-cn.com/problems/number-of-ways-to-paint-n-3-grid/solution/gei-n-x-3-wang-ge-tu-tu-se-de-fang-an-shu-by-leetc/
 */
public class NumOfWays {
    final int MOD = 1000000007;
    public int numOfWays(int n) {
        long w1 = 6;
        long w2 = 6;
        while(--n >= 1){
            long new_w1 = (2 * w1 + 2 * w2) % MOD;
            long new_w2 = (2 * w1 + 3 * w2) % MOD;
            w1 = new_w1;
            w2 = new_w2;
        }

        return (int)(w1 + w2) % MOD;
    }
}
