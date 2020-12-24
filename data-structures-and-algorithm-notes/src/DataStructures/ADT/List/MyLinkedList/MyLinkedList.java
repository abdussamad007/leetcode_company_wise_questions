package DataStructures.ADT.List.MyLinkedList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private int theSize;
    private int modCount;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    public MyLinkedList() {
        clear();
    }

    private void clear() {
        beginMarker = new Node<T>(null, null, null);
        endMarker = new Node<T>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(T t) {
        add(size(), t);
        return true;
    }

    public void add(int index, T t) {
        addBefore(getNode(index, 0, size()), t);
    }
  private void addBefore(Node<T> p, T t) {
//        if (p == beginMarker) {
//            Node<T> newNode = new Node<>(t, beginMarker, beginMarker.next);
//            beginMarker.next.prev = p;
//            beginMarker.next = newNode;
//        }else {
//            Node<T> newNode = new Node<>(t, p.prev, p);
//            newNode.prev.next = newNode;
//            p.prev = newNode;
//        }
        Node<T> newNode = new Node<>(t, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    public T get(int index) {
        return getNode(index).data;
    }

    public T set(int index, T t) {
        Node<T> node = getNode(index);
        T oldValue = node.data;
        node.data = t;
        return oldValue;
    }


    public T remove(int index) {
        return remove(getNode(index));
    }
    private T remove(Node<T> p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        modCount++;
        theSize--;
        return p.data;
    }

    private Node<T> getNode(int index) {
        return getNode(index, 0, size() - 1);
    }
    private Node<T> getNode(int index, int lower, int upper) {
        Node<T> p;
        if (index < lower || index > upper) {
            throw new IndexOutOfBoundsException();
        }

        if (index < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > index; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> p = beginMarker;
        while (p.next != endMarker) {
            str += p.next.data.toString() + "\n";
            p = p.next;
        }
        return str;
    }


    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private static class Node<T> {
        // 元素内容
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T d, Node<T> p, Node<T> n) {
            data = d;
            prev = p;
            next = n;
        }
    }


    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public T next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }

            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    }
}
