package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-01-26
 */
public class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            boolean isPrimes = true;
            for (int j = 2; j < i ; j++) {
                if(i % j == 0){
                    isPrimes = false;
                    break;
                }
            }
            if(isPrimes) count++;
        }
        return count;
    }
}
