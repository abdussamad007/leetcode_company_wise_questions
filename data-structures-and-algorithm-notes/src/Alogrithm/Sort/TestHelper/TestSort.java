package Alogrithm.Sort.TestHelper;

import Alogrithm.Sort.BaseSort;

public class TestSort {
    public static void testSort(String name, Integer[] arr, BaseSort baseSort) {
        double startTime = System.currentTimeMillis();
        baseSort.sort(arr);
        double endTime = System.currentTimeMillis();
        double dSecs = (endTime - startTime) / 1000d;
        if (assertIsOrdered(arr)) {
            System.out.println(" -" + name + " - " + dSecs + "s");
        }
    }

    private static boolean assertIsOrdered(Integer[] arr) {
        boolean b = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println("--");
                b = false;
                return b;
            }
        }
        return b;
    }
}
