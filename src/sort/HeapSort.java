package sort;

import java.util.Random;

/**
 * 堆排序
 * 排序时间 757459 纳秒
 */
public class HeapSort {

    private static <T extends Comparable<? super T>> void sink(T[] nums, int hole, int n) {

        T tmp = nums[hole];
        int child = 0;

        while (2 * hole + 1 < n) {
            child = 2 * hole + 1;
            if (child != n - 1 && nums[child].compareTo(nums[child + 1]) < 0) {
                child++;
            }

            if (tmp.compareTo(nums[child]) < 0) {
                nums[hole] = nums[child];
            } else {
                break;
            }
            hole = child;
        }
        nums[hole] = tmp;
    }

    public static <T extends Comparable<? super T>> void sort(T[] nums) {

        if (nums == null || nums.length == 0)
            throw new NullPointerException("没有值啊 兄弟");

        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            sink(nums, i, nums.length);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            CommonUtil.swap(nums, 0, i);

            sink(nums, 0, i);
        }
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
