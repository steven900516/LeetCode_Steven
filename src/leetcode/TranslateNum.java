package leetcode;

/**
 * @author Steven0516
 * @create 2021-09-16
 */

//把数字翻译成字符串
//动态规划   dp状态方程
public class TranslateNum {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        //这里注意数组大小length+1
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= s.length(); i ++){
            //注意substring下标
            String temp = s.substring(i-2, i);
            if(temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0)
                //状态方程1，
                dp[i] = dp[i-1] + dp[i-2];
            else
                //状态方程2,举例12258,截取58>25，dp[5]和dp【4】一致
                dp[i] = dp[i-1];
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        try {
            System.out.println("12258".charAt(5));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("12258".substring(3, 5));
        }

    }


}
