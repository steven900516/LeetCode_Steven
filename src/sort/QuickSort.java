package sort;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2021-11-13
 */
public class QuickSort {

    public void quickSort(int[] arr, int start, int end) {
        if(start >= end ){
            return;
        }

        int pivotIdx = partition(arr, start, end);
        quickSort(arr, start, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, end);
    }

    private int partition(int[] arr, int start, int end) {

        int pivotIdx = start;
        int counter = start + 1;
        for (int i = start + 1; i <= end; i++) {
            if(arr[i] < arr[pivotIdx]){
                swap(arr,i,counter);
                counter++;
            }
        }
        swap(arr,counter - 1,pivotIdx);
        return counter - 1;
    }

    private void swap(int[] arr, int i, int counter) {
        int temp = arr[i];
        arr[i] = arr[counter];
        arr[counter] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] ints = new int[]{5,15,12,3,2,18,21};
        quickSort.quickSort(ints,0,ints.length - 1);
        for(Integer intss: ints){
            System.out.println(intss);
        }

    }
}
