package Alogrithm.Sort.InsertionSort;

import Alogrithm.Sort.BaseSort;
public class InsertionSort extends BaseSort {

    public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
        int p;
        for (int i = 1; i < arr.length; i++) {
            T tmp = arr[i];
            for (p = i; p > 0 && tmp.compareTo(arr[p - 1]) < 0; p--) {
                arr[p] = arr[p - 1];
            }
            arr[p] = tmp;
        }
    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] arr, int l, int r) {
        int p;
        for (int i = l + 1; i <= r; i++) {
            T tmp = arr[i];
            for (p = i; p > l && tmp.compareTo(arr[p - 1]) < 0; p--) {
                arr[p] = arr[p - 1];
            }
            arr[p] = tmp;
        }
    }

    @Override
    public <T extends Comparable<? super T>> void sort(T[] array) {
        insertionSort(array);
    }
}
