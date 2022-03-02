package Ali;

/**
 * @author Steven0516
 * @create 2022-03-02
 */
public class FindKthPositive {
    public int findKthPositive(int[] arr, int k) {
        int cur = 1;
        int i = 0;
        while(i < arr.length){
            if(k == 0){
                return cur;
            }
            if(cur != arr[i]){
                k--;
            }else{
                i++;
            }
            cur++;
        }

        return k - cur;
    }
}
