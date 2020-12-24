package Alogrithm.Sort.HeapSort;

import Alogrithm.Sort.BaseSort;
public class HeapSort extends BaseSort {
    public static <T extends Comparable<? super T>> void heapSort(T[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            percolateDown(array, i, array.length);
        }
        for (int i = array.length - 1; i > 0; i--) {
            swapReferences(array, 0, i);
            percolateDown(array, 0, i);
        }
    }
    private static int getLeftChildIndex(int i) {
        return i * 2 + 1;
    }

    private static <T extends Comparable<? super T>> void percolateDown(T[] array, int i, int n) {
        int child;
        T tmp = array[i];
        for (; getLeftChildIndex(i) < n; i = child) {
            child = getLeftChildIndex(i);
            if (child != n - 1 && array[child].compareTo(array[child + 1]) < 0) {
                child++;
            }
            if (tmp.compareTo(array[child]) < 0) {
                array[i] = array[child];
            } else {
                break;
            }
        }
        array[i] = tmp;
    }

    public static <T> void swapReferences(T[] array, int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    @Override
    public <T extends Comparable<? super T>> void sort(T[] array) {
        heapSort(array);
    }
}
