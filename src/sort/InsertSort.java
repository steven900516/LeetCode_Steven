package sort;

/**
 * @author Steven0516
 * @create 2021-12-08
 */
public class InsertSort {
    public static void insertSort(int[] arr) {
        int len = arr.length;
        if (len < 2)
            return ;
        for (int idx = 0; idx < len; idx++) {
            for (int i = idx; i > 0; i--) {
                if (arr[i - 1] < arr[i]) {
                    break;
                } else {
                    swap(arr, i - 1, i);
                }
            }
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{8,32,6,66,23,78};
        insertSort(ints);
        for(Integer i: ints){
            System.out.println(i);
        }
    }
}
