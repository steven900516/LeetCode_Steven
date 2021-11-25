package company;

/**
 * @author Steven0516
 * @create 2021-11-24
 */
public class MySqrt {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        if(x == 1){
            return 1;
        }
        int left = 1;
        int right = x / 2;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid == x / mid){
                return mid;
            }else if(mid  > x / mid){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
