package game;

import java.util.LinkedList;

/**
 * @author Steven0516
 * @create 2021-12-05
 */
public class FindEvenNumbers {
    LinkedList<Integer> res = new LinkedList<>();
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        for(int i = 0;i < n;i++){
            for(int j = i + 1;j < n;j++){
                for(int k = j + 1;k < n;k++){
                    if(digits[i] != 0 && (digits[i] * 100 + digits[j] * 10 + digits[k] % 2 == 0)){
                        res.add(digits[i] * 100 + digits[j] * 10 + digits[k] % 2);
                    }
                }
            }
        }

        int[] ints = new int[res.size()];
        int i  = 0;
        for(Integer a: res){
            ints[i] = a;
            i++;
        }
        return ints;
    }
}
