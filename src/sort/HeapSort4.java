package sort;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2022-03-20
 */
public class HeapSort4 {

    public void heapSort(int[] nums,int length){
        for (int i = length / 2 - 1; i >= 0 ; i--) {
            buildHeap(nums,i,length);
        }

        for (int i = nums.length - 1; i >= 0 ; i--) {
            swap(0,nums,i);
            length--;
            buildHeap(nums,0,length);
        }
    }



    private void buildHeap(int[] nums, int i, int length) {
        int tmp = nums[i];
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if(j + 1 < length && nums[j + 1] > nums[j]){
                j++;
            }

            if(nums[j] > tmp){
                nums[i] = nums[j];
                i = j;
            }else{
                break;
            }
        }
        nums[i] = tmp;
    }

    private void swap(int head, int[] nums, int tail) {
        int tmp = nums[head];
        nums[head] = nums[tail];
        nums[tail] = tmp;
    }

    public static void main(String[] args) {
        HeapSort4 heapSort4 = new HeapSort4();
        int[] nums = new int[]{30,2,55,8,3,32,11,90};
        heapSort4.heapSort(nums,nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
