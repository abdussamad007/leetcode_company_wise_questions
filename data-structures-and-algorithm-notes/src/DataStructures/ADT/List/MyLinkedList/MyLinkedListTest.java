package DataStructures.ADT.List.MyLinkedList;

import java.util.Iterator;

public class MyLinkedListTest {
    public static void main(String[] args) {
MyLinkedList<Integer> list = new MyLinkedList<>();
        System.out.println("list:" + list.size());
        System.out.println("list:" + list.isEmpty());

        list.add(1);
        list.add(2);

        list.add(0, 100);
        System.out.println("list:" + list.get(0));

        list.set(0, 200);
        System.out.println("list:" + list.get(0));

        list.remove(1);
        System.out.println("list:");
        System.out.println(list);

        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        itr = list.iterator();
        while (itr.hasNext()) {
            itr.next();
            itr.remove();
        }
        System.out.println("list:" + list.isEmpty());
    }
}
