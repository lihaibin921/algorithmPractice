package sort;

import java.util.Random;

/**
 * 大佬写的快速排序
 */
public class QuickSort2 {

    private static final int CUTOFF = 3;

    public static <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] a) {
        quicksort(a, 0, a.length - 1);
    }

    public static <AnyType> void swapReferences(AnyType[] a, int index1, int index2) {
        AnyType tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    private static <AnyType extends Comparable<? super AnyType>> AnyType median3(AnyType[] a, int left, int right) {
        int center = (left + right) / 2;
        if (a[center].compareTo(a[left]) < 0)
            swapReferences(a, left, center);
        if (a[right].compareTo(a[left]) < 0)
            swapReferences(a, left, right);
        if (a[right].compareTo(a[center]) < 0)
            swapReferences(a, center, right);

        // Place pivot at position right - 1
        swapReferences(a, center, right - 1);
        return a[right - 1];
    }

    private static <AnyType extends Comparable<? super AnyType>> void quicksort(AnyType[] a, int left, int right) {
        if (left + CUTOFF <= right) {
            AnyType pivot = median3(a, left, right);

            // Begin partitioning
            int i = left, j = right - 1;
            for (; ; ) {
                while (a[++i].compareTo(pivot) < 0) {
                }
                while (a[--j].compareTo(pivot) > 0) {
                }
                if (i < j)
                    swapReferences(a, i, j);
                else
                    break;
            }

            swapReferences(a, i, right - 1);   // Restore pivot

            quicksort(a, left, i - 1);    // Sort small elements
            quicksort(a, i + 1, right);   // Sort large elements
        } else  // Do an insertion sort on the subarray
            insertionSort(a, left, right);
    }

    private static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] a, int left, int right) {
        for (int p = left + 1; p <= right; p++) {
            AnyType tmp = a[p];
            int j;

            for (j = p; j > left && tmp.compareTo(a[j - 1]) < 0; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }

    public static void main(String[] args) {

        Integer[] nums = new Integer[10000];

        Random r = new Random(53);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(99999);
        }

        long time = System.nanoTime();
        sort(nums);
        time = System.nanoTime() - time;

        System.out.println("排序时间 " + time + " 纳秒");
        for (Integer i : nums) {
            System.out.print(i + ",");
        }
    }
}
