package DataStructures.ADT.List.MyArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private T[] theItems;

    public MyArrayList() {
        clear();
    }

    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public int length() {
        return theItems.length;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        T[] old = theItems;
        theItems = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[index];
    }

    public T set(int index, T t) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T old = theItems[index];
        theItems[index] = t;
        return old;
    }

    public void add(int index, T t) {
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = size(); i > index; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[index] = t;
        theSize++;
    }

    public void add(T t) {
        add(size(), t);
    }

    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T rmT = theItems[index];
        for (int i = index; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return rmT;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < size(); i++) {
            if (theItems[i] != null) {
                str += theItems[i].toString() + "\n";
            } else {
                str += "null\n";
            }
        }
        return str;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {

        private int current = 0;
        @Override
        public boolean hasNext() {
            return current < size();
        }
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
