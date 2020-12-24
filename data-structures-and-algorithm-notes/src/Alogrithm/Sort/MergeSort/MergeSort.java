package Alogrithm.Sort.MergeSort;

import Alogrithm.Sort.BaseSort;

public class MergeSort extends BaseSort {
    public static <T extends Comparable<? super T>> void mergeSort(T[] a) {
        T[] tmpArr = (T[]) new Comparable[a.length];
        mergeSort(a, tmpArr, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>>
    void mergeSort(T[] a, T[] tmpArr, int leftPos, int rightPos) {
        if (leftPos < rightPos) {
            int centerPos = (leftPos + rightPos) / 2;
            mergeSort(a, tmpArr, leftPos, centerPos);
            mergeSort(a, tmpArr, centerPos + 1, rightPos);

            merge(a, tmpArr, leftPos, centerPos + 1, rightPos);
        }
    }

    private static <T extends Comparable<? super T>>
    void merge(T[] a, T[] tmpArr, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos].compareTo(a[rightPos]) <= 0) {
                tmpArr[tmpPos++] = a[leftPos++];
            } else {
                tmpArr[tmpPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd) {
            tmpArr[tmpPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd) {
            tmpArr[tmpPos++] = a[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArr[rightEnd];
        }
    }

    @Override
    public <T extends Comparable<? super T>> void sort(T[] array) {
        mergeSort(array);
    }
}
