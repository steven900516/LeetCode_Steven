package labuladong.Search;

/**
 * @author Steven0516
 * @create 2021-10-21
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int left = 1;
        int right = 501;
        while(left < right){
            int mid = left + (right - left ) / 2;
            if(cDays(weights,mid) == days){
                right = mid;
            }else if(cDays(weights,mid) > days){
                left = mid + 1;
            }else if(cDays(weights,mid) < days){
                right = mid;
            }
        }

        return left;
    }


    public int cDays(int[] weights, int heavy){
        int totalW = 0;
        int time = 0;
        for(int i = 0;i < weights.length;i++){
            totalW += weights[i];
            if(totalW > heavy){
                totalW -= weights[i];
                time++;
                i--;
                totalW = 0;
            }else if(totalW < heavy && i == weights.length - 1){
                time++;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        ShipWithinDays shipWithinDays = new ShipWithinDays();
        System.out.println(shipWithinDays.cDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 15));
    }
}
