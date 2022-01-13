package SpringTest.First;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2022-01-12
 */
public class Coins {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void caculate() throws IOException {
        Integer money = Integer.parseInt(br.readLine());
        cac(1024 - money);
    }

    private void cac(Integer money) {
        int[] coins = new int[]{64,16,4,1};
        int n = coins.length;
        int[] dp = new int[money + 1];
        Arrays.fill(dp, money + 1);
        dp[0] = 0;
        for(int i = 0;i < dp.length;i++){
            for(Integer coin: coins){
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        System.out.println((dp[money] == money + 1) ? 0 : dp[money]);
    }

    public static void main(String[] args) throws IOException {
        Coins coins = new Coins();
        coins.caculate();
    }
}
