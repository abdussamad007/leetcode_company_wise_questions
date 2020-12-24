package Alogrithm.Sort;

public abstract class BaseSort {
    public abstract <T extends Comparable<? super T>> void sort(T[] array);
}
