package DataStructures.ADT.List.MyArrayList;

import java.util.Iterator;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>();
        System.out.println("list1的元素个数为:" + list1.size());
        System.out.println("list1为空：" + list1.isEmpty());
        System.out.println("list1的长度为:" + list1.length());

        list1.add(1);
        list1.add(2);
        System.out.println("list:" + list1.get(0));

        list1.add(0, 100);
        System.out.println("List:" + list1.get(0));

        list1.set(1, 200);
        System.out.println("List:" + list1.get(1));

        list1.remove(2);
        System.out.println("List:");

        System.out.println(list1);
        for (int i = 3; i < 15; i++) {
            list1.add(i);
        }
        System.out.println("list:");
        System.out.println(list1);

        System.out.println("list:" + list1.length());
        list1.trimToSize();
        System.out.println("trimToSize:" + list1.length());

        Iterator itr = list1.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next().toString());
        }

        itr = list1.iterator();
        while (itr.hasNext()) {
            itr.next();
            itr.remove();
        }
        System.out.println("list" + list1.isEmpty());
    }
}
