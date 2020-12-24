package Alogrithm.Sort.TestHelper;

public class IntegerTestTool {
    public static Integer[] getRandomArr(Integer start, Integer end, Integer num) {
        Integer[] res = new Integer[num];
        for (int i = 0; i < num; i++) {
            res[i] = (int) ((Math.random()) * end - start);
        }
        return res;
    }

    public static Integer[] copyArr(Integer[] oriArr) {
        return oriArr.clone();
    }

    public static Integer[] getNearlyOrderedArr(int num, int swapTimes) {
        Integer[] arr = new Integer[num];
        for (int i = 0; i < num; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < swapTimes; i++) {
            int a = (int) ((Math.random()) * num);
            int b = (int) ((Math.random()) * num);
            swap(arr, a, b);
        }
        return arr;
    }

    public static Integer[] swap(Integer[] arr, int a, int b) {
        int tmp;
        tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        return arr;
    }

    public static void printlnArr(Integer[] ints) {
        for (Integer i : ints) {
            System.out.println(i);
        }
    }

    public static void printArr(Integer[] ints) {
        for (Integer i : ints) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
