package sort;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2021-12-13
 */
public class HeapSort2 {

    public static void HeapSort(int[] arr,int length){
        for(int i = arr.length / 2 - 1;i >= 0;i--){
            maxHeapSort(i,arr,length);
        }

        for(int i = length - 1;i >= 0;i--){
            swap(i,0,arr);
            length--;
            maxHeapSort(0,arr,length);
        }
    }

    private static void swap(int l, int r, int[] arr) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    private static void maxHeapSort(int i, int[] arr, int length) {
        int temp = arr[i];
        for(int j = i * 2 + 1;j < length;j = j * 2 + 1){
            if(j + 1 < length &&  arr[j] < arr[j + 1]){
                j++;
            }
            if(arr[j] > temp){
                arr[i] = arr[j];
                i = j;
            }else{
                break;
            }
        }
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,6,8,5,9};
        int length = arr.length;
        HeapSort(arr,length);
        System.out.println(Arrays.toString(arr));
    }
}
