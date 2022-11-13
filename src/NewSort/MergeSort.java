package NewSort;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] nums,int[] tmp,int left,int right){
        if (left >= right){
            return;
        }
        System.out.println(left + "," + right);
        int mid = left + (right  - left) / 2;
        mergeSort(nums,tmp,left,mid);
        mergeSort(nums,tmp,mid + 1,right);
        merge(nums,mid,tmp,left,right);
    }

    private void merge(int[] nums, int mid, int[] tmp, int left, int right) {
        int indexA = left;
        int indexB = mid + 1;
        int index = left;
        while (indexA <= mid && indexB <= right){
            if (nums[indexA] <= nums[indexB]) {
                tmp[index] = nums[indexA];
                indexA++;
            }else {
                tmp[index] = nums[indexB];
                indexB++;
            }
            index++;
        }

        if (indexA > mid){
            while(indexB <= right){
                tmp[index++] = nums[indexB++];
            }
        }

        if (indexB > right){
            while(indexA <= mid){
                tmp[index++] = nums[indexA++];
            }
        }

        for (int i = left; i <= right ; i++) {
            nums[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] nums = new int[]{20,40,10,4,90,39,10,99,2};
        mergeSort.mergeSort(nums,new int[9],0,8);
        System.out.println(Arrays.toString(nums));
    }
}
