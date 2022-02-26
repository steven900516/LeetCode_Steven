package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2022-02-24
 */
public class StableQuickSorter<T extends Comparable<T>> {
    public void sort(List<T> list) {
        if (list == null) {
            return ;
        }
        List<T> tmp = new ArrayList<T>();
        quickSort(list, tmp, 0, list.size() - 1);
    }

    private void quickSort(List<T> list, List<T> tmp, int from, int to) {
        if (from >= to) {
            return;
        }
        int index = partition(list, tmp, from, to);
        quickSort(list, tmp, from, index - 1);
        quickSort(list, tmp, index + 1, to);
    }

    private int partition(List<T> list, List<T> tmp, int from, int to) {
        T flag = list.get(from);
        tmp.clear();
        int index;
        for (int i = from + 1; i <= to; i++) {
            T item = list.get(i);
            if (item.compareTo(flag) < 0) {
                tmp.add(item);
            }
        }
        index = from + tmp.size();
        tmp.add(flag);
        for (int i = from + 1; i <= to; i++) {
            T item = list.get(i);
            if (item.compareTo(flag) >= 0) {
                tmp.add(item);
            }
        }

        for (int i = 0; i < tmp.size(); i++) {
            list.set(from + i, tmp.get(i));
        }
        return index;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        StableQuickSorter<Integer> sorter = new StableQuickSorter<Integer>();
        sorter.sort(list);

        for (int value : list) {
            System.out.println(value);
        }
    }

}
