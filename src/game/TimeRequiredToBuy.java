package game;

/**
 * @author Steven0516
 * @create 2021-11-14
 */
public class TimeRequiredToBuy {
    public static  int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int second = 0;
        while(tickets[k] > 0 ){
            for(int i = 0;i < n;n++){
                if(tickets[i] == 0){
                    continue;
                }
                tickets[i]--;
                second++;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[]{2, 3, 2}, 2));
    }
}
