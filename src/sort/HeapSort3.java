package sort;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2021-12-25
 */
public class HeapSort3 {
    public static void heapSort(int[] arr){
        int n = arr.length;
        for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
           heapify(i,arr,n);
        }

        for(int i = arr.length - 1;i >= 0;i--){
            swap(arr,i,0);
            n--;
            heapify(0,arr, n);
        }

    }

    private static void heapify(int i, int[] arr,int length) {
        int temp = arr[i];
        for(int j = i * 2 + 1;j < length;j = j * 2 + 1){
            if(j + 1 < length && arr[j] < arr[j + 1]){
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

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,6,8,5,9};

        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
