package sort;

import java.util.Random;

/**
 * 归并排序
 * 排序时间 175304 纳秒
 */
public class MergeSort {

    private static <T extends Comparable<? super T>> void merge(T[] nums, T[] tmp, int le, int ri, int riEnd) {

        int leEnd = ri - 1;
        int begin = le;
        int len = riEnd - le + 1;

        while (le <= leEnd && ri <= riEnd) {
            if (nums[le].compareTo(nums[ri]) < 0) {
                tmp[begin++] = nums[le++];
            } else {
                tmp[begin++] = nums[ri++];
            }
        }

        while (le <= leEnd) {
            tmp[begin++] = nums[le++];
        }

        while (ri <= riEnd) {
            tmp[begin++] = nums[ri++];
        }

        for (int i = 0; i < len; i++, riEnd--) {
            nums[riEnd] = tmp[riEnd];
        }
    }

    private static <T extends Comparable<? super T>> void MergeSort(T[] nums, T[] tmp, int le, int riEnd) {
        if (le < riEnd) {
            int center = (le + riEnd) / 2;
            MergeSort(nums, tmp, le, center);
            MergeSort(nums, tmp, center + 1, riEnd);
            merge(nums, tmp, le, center + 1, riEnd);
        }
    }

    public static <T extends Comparable<? super T>> void sort(T[] nums) {
        if (nums == null || nums.length == 0)
            throw new NullPointerException("没有值啊 兄弟");

        T[] tmp = (T[]) new Comparable[nums.length];

        MergeSort(nums, tmp, 0, nums.length - 1);
    }

    public static void main(String[] args) {

        Integer[] nums = new Integer[100];

        Random r = new Random(53);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(999);
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
