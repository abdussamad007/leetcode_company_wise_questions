package Alogrithm.Sort.QuickSort;

import Alogrithm.Sort.BaseSort;

public class QuickSort extends BaseSort {
    private volatile static int nums = 0;

    public static <T extends Comparable<? super T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<? super T>> void quickSort(T[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private static <T extends Comparable<? super T>> int partition(T[] arr, int l, int r) {
        T tmp = arr[l];
        int j = l + 1;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(tmp) < 0) {
                swapReferences(arr, i, j);
                j++;
            }
        }
        swapReferences(arr, l, j - 1);
        return j - 1;
    }

    public static <T> void swapReferences(T[] array, int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }


    @Override
    public <T extends Comparable<? super T>> void sort(T[] array) {
        quickSort(array);
    }
}
