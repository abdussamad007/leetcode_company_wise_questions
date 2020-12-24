package Alogrithm.Sort.ShellSort;

import Alogrithm.Sort.BaseSort;
public class ShellSort extends BaseSort {

    public static <T extends Comparable<? super T>> void shellSort(T[] arr) {
        int p;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                T tmp = arr[i];
                for (p = i; p >= gap && tmp.compareTo(arr[p - gap]) < 0; p -= gap) {
                    arr[p] = arr[p - gap];
                }
                arr[p] = tmp;
            }
        }
    }

    @Override
    public <T extends Comparable<? super T>> void sort(T[] array) {
        shellSort(array);
    }
}
