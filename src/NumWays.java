/**
 * @author Steven0516
 * @create 2021-09-14
 */

//青蛙跳台阶
//回溯算法超时
public class NumWays {
    int tot;
    public int numWays(int n) {
        backTrack(n,0);
        return tot;
    }


    private void backTrack(int n,int sum){
        if(sum > n){
            return;
        }

        if(sum == n){
            tot++;
            sum = 0;
            return;
        }

        for(int i = 1;i <= 2;i++){
            sum += i;
            backTrack(n,sum);
            sum -= i;
        }
    }

    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        System.out.println(numWays.numWays(41));
    }
}
