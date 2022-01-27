package Micrsoft;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Steven0516
 * @create 2022-01-26
 */
public class IsHappy {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        Set<Integer> seen = new HashSet<>();
        while(n != 1 && !seen.contains(n)){
            seen.add(n);
            n = getNext(n);
            System.out.println(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int res = 0;
        while(n != 0){
            int digit = n % 10;
            res += digit * digit;
            n = n / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        System.out.println(isHappy.isHappy(2));
    }
}
