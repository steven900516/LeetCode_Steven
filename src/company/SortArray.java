package company;

/**
 * @author Steven0516
 * @create 2021-11-20
 */
public class SortArray {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums,int start,int end){
        if(start >= end){
            return;
        }

        int pivotIdx = partition(nums,start,end);
        quickSort(nums,start,pivotIdx);
        quickSort(nums,pivotIdx + 1,end);
    }

    public int partition(int[] nums,int start,int end){
        int pivotIdx = start;
        int counter = start + 1;

        for(int i = start + 1; i <= end;i++){
            if(nums[i] < nums[pivotIdx]){
                swap(nums,i,counter);
                counter++;
            }
        }
        swap(nums,counter - 1,pivotIdx);
        return counter - 1;
    }

    public void swap(int[] nums,int start,int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
