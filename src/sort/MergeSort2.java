package sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Steven0516
 * @create 2021-12-13
 */


//快速排序：先确定左右子数组，然后再对左右子数组分别进行排序
//归并排序：先排序左右子数组，然后再合并两个子数组


public class MergeSort2 {
    public static void mergeSort(int[] arr,int left,int right,int[] tmp){
        if(left >= right){
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr,left,mid,tmp);
        mergeSort(arr,mid + 1,right,tmp);
        merge(arr,left,mid,right,tmp);
    }

    private static void merge(int[] arr, int left,int mid, int right, int[] tmp) {
        int leftPtr = left,rightPtr = mid + 1,index = left;
        while(leftPtr <= mid && rightPtr <= right){
            if(arr[leftPtr] < arr[rightPtr]){
                tmp[index] = arr[leftPtr];
                leftPtr++;
            }else{
                tmp[index] = arr[rightPtr];
                rightPtr++;
            }
            index++;
        }
        while (leftPtr <= mid) {
            tmp[index++] = arr[leftPtr++];
        }
        while (rightPtr <= right) {
            tmp[index++] = arr[rightPtr++];
        }


        while (left <= right) {
            arr[left] = tmp[left];
            left++;
        }

    }

    public static void main(String[] args) {
        int[] arr = {5, 15, 12, 3, 2, 18, 21};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length - 1,temp);
        System.out.println(Arrays.toString(arr));
    }
}
