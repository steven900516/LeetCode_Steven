package labuladong.Map;

/**
 * @author Steven0516
 * @create 2021-10-18
 */
public class FindCelebrity {
    int findCelebrity(int n) {
        // 先假设 cand 是名人
        int cand = 0;
        for (int other = 1; other < n; other++) {
            if (!knows(other, cand) || knows(cand, other)) {
                // cand 不可能是名人，排除
                // 假设 other 是名人
                cand = other;
            } else {
                // other 不可能是名人，排除
                // 什么都不用做，继续假设 cand 是名人
            }
        }

        // 现在的 cand 是排除的最后结果，但不能保证一定是名人
        for (int other = 0; other < n; other++) {
            if (cand == other) continue;
            // 需要保证其他人都认识 cand，且 cand 不认识任何其他人
            if (!knows(other, cand) || knows(cand, other)) {
                return -1;
            }
        }

        return cand;
    }


    //官方提供api  other是否认识cand
    private boolean knows(int other, int cand) {

        return true;
    }
}
