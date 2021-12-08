package sort;

import java.util.Random;

/**
 * @author Steven0516
 * @create 2021-12-08
 */
public class QuickSortRandom {
    Random random = new Random();

    public void quickSort(int[] arr, int start, int end) {
        // 规模小时采用插入排序
//        if (right - left <= k) {
//            insertionSort(arr, left, right);
//            return;
//        }


        if(start >= end ){
            return;
        }

        int pivotIdx = partition(arr, start, end);
        quickSort(arr, start, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        swap(arr,start,random.nextInt(end - start + 1) + start);
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
        System.out.println("--------------------随机为基准值");
        QuickSortRandom quickSort = new QuickSortRandom();
        int[] ints = new int[]{1,2,3,4,5,6,7,8,9,10,23,234,543,646,3434,443,3256,64747,23234,23432432,234323242,23432,234324,6546,674745};
        long l = System.nanoTime();
        quickSort.quickSort(ints,0,ints.length - 1);
        System.out.println(System.nanoTime() - l);
        System.out.println("----");
        for(Integer intss: ints){
            System.out.println(intss);
        }


        System.out.println("----------------------左边为基准值");
        QuickSort quickSort2 = new QuickSort();
        long l2=  System.nanoTime();
        quickSort2.quickSort(ints,0,ints.length - 1);
        System.out.println(System.nanoTime() - l2);
        System.out.println("----");

        for(Integer intss: ints){
            System.out.println(intss);
        }
    }
}
