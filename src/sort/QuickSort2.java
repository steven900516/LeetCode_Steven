package sort;

/**
 * @author Steven0516
 * @create 2021-12-07
 */
public class QuickSort2 {
    public void quickSort(int[] arr,int start,int end){
        if(start >= end){
            return;
        }
        int pivotIdx = partition(arr,start,end);
        quickSort(arr,start,pivotIdx - 1);
        quickSort(arr,pivotIdx + 1,end);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = start;
        int cur = start + 1;
        for(int i = start + 1;i <= end;i ++){
            if(arr[i] < arr[pivot]){
                swap(arr,i,cur);
                cur++;
            }
        }
        swap(arr,pivot,cur - 1);
        return cur - 1;
    }

    private void swap(int[] arr, int i, int cur) {
        int tmp = arr[cur];
        arr[cur] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        QuickSort2 quickSort = new QuickSort2();
        int[] ints = new int[]{1,1,1,1};
        quickSort.quickSort(ints,0,ints.length - 1);
        for(Integer intss: ints){
            System.out.println(intss);
        }

    }
}
