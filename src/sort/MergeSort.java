package sort;

import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2021-11-14
 */
public class MergeSort {
    public void mergeSort(int[] arr, int left, int right, int[] temp) {
        if(left >= right){
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        merge(arr,left,mid,right,temp);
    }

    public void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int leftPtr = left;
        int rightPtr = mid + 1;
        int index = left;    //temp数组下标
        while(leftPtr <= mid && rightPtr <= right){
            if(arr[leftPtr] < arr[rightPtr]){
                temp[index] = arr[leftPtr];
                leftPtr++;
            }else{
                temp[index] = arr[rightPtr];
                rightPtr++;
            }
            index++;
        }

        while(leftPtr <= mid){
            temp[index] = arr[leftPtr];
            leftPtr++;
            index++;
        }

        while(rightPtr <= right){
            temp[index] = arr[rightPtr];
            rightPtr++;
            index++;
        }


        //把合并后的结果赋值回去
        while (left <= right) {
            arr[left] = temp[left];
            left++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 15, 12, 3, 2, 18, 21};
        MergeSort mergeSort = new MergeSort();
        int[] temp = new int[arr.length];
        mergeSort.mergeSort(arr,0, arr.length - 1,temp);
        for(Integer integer: arr){
            System.out.println(integer);
        }
    }
}
