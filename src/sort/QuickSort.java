package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * 快速排序
 * 排序时间 177356 纳秒
 */
public class QuickSort {

    private static <T extends Comparable<? super T>> int partition(T[] nums, int low, int hi) {

        T p = nums[low];

        while (low < hi) {
            while (low < hi && nums[hi].compareTo(p) >= 0) {
                hi--;
            }
            nums[low] = nums[hi];

            while (low < hi && nums[low].compareTo(p) < 0) {
                low++;
            }
            nums[hi] = nums[low];
        }

        nums[low] = p;
        return low;
    }

    private static <T extends Comparable<? super T>> void sort(T[] nums, int low, int hi) {

        if (low < hi) {
            int re = partition(nums, low, hi);
            sort(nums, low, re - 1);
            sort(nums, re + 1, hi);
        }

    }

    public static <T extends Comparable<? super T>> void sort(T[] nums) {
        if (nums == null || nums.length == 0)
            throw new NullPointerException("没有值啊 兄弟");

        sort(nums, 0, nums.length - 1);
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
