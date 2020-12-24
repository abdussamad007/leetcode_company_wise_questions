package DataStructures.ADT.Heap.BinaryHeap;
public class BinaryHeap<T extends Comparable<? super T>> {
    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        arr = (T[]) new Comparable[capacity + 1];
    }

    public BinaryHeap(T[] items) {
        currentSize = items.length;
        arr = (T[]) new Comparable[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (T item : items) {
            arr[i++] = item;
        }
        buildHeap();
    }

    public void insert(T t) {
        if (currentSize == arr.length - 1) {
            enlargeArray(arr.length * 2 + 1);
        }
        int hole = ++currentSize;
        for (arr[0] = t; t.compareTo(arr[hole / 2]) < 0; hole /= 2) {
            arr[hole] = arr[hole / 2];
        }
        arr[hole] = t;
    }

    public T findMin() {
        if (isEmpty()) {
        }
        return arr[1];
    }

    public T deleteMin() {
        if (isEmpty()) {
            // throw new UnderflowException( );
        }
        T minItem = findMin();
        arr[1] = arr[currentSize--];
        percolateDown(1);
        return minItem;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        currentSize = 0;
    }

    public void print(){
        System.out.print("堆为:");
        for (int i = 1;arr[i] != null;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;
    private T[] arr;

    private void percolateDown(int hole) {
        int child;
        T tmp = arr[hole];

        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && arr[child + 1].compareTo(arr[child]) < 0) {
                child++;
            }
            if (arr[child].compareTo(tmp) < 0) {
                arr[hole] = arr[child];
            } else {
                break;
            }
        }
        arr[hole] = tmp;
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    private void enlargeArray(int newSize) {
        T[] old = arr;
        arr = (T[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++) {
            arr[i] = old[i];
        }
    }
}
