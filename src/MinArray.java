/**
 * @author Steven0516
 * @create 2021-09-11
 */

//旋转数组的最小数字  ：二分
public class MinArray {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int mid = (left + right)/2;
            if(numbers[mid] > numbers[right]){
                left = mid + 1;
            }else if(numbers[mid] < numbers[right]){
                right = mid;
            }else{
                right--;     //缩小范围
            }
        }
        return numbers[left];
    }
}
