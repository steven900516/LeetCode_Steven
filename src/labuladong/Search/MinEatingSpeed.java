package labuladong.Search;

/**
 * @author Steven0516
 * @create 2021-10-21
 */
public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000 + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) == h) {
                // 搜索左侧边界，则需要收缩右侧边界
                right = mid;
            } else if (f(piles, mid) < h) {
                // 需要让 f(x) 的返回值大一些
                right = mid;
            } else if (f(piles, mid) > h) {
                // 需要让 f(x) 的返回值小一些
                left = mid + 1;
            }
        }
        return left;
    }


    private int f(int[] piles, int x) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / x;
            if (piles[i] % x > 0) {
                hours++;
            }
        }
        return hours;
    }
}
