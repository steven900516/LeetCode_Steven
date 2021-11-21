package company;

/**
 * @author Steven0516
 * @create 2021-11-21
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        if(n == 1){
            return ans;
        }

        ans[n - 1] = 0;
        for(int i = 0;i < n - 1;i++){
            for(int j = i + 1;j < n;j++){
                if(temperatures[j] > temperatures[i]){
                    ans[i] = j - i;
                    break;
                }
            }
        }

        return ans;
    }
}
