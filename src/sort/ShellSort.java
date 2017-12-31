package sort;

import java.util.Random;

/**
 * 希尔排序
 * 排序时间 199115 纳秒
 */
public class ShellSort {

    public static <T extends Comparable<? super T>> void sort(T[] nums) {

        if (nums == null || nums.length == 0)
            throw new NullPointerException("没有值啊 兄弟");

        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < nums.length; i++) {
                T tmp = nums[i];
                int j;
                for (j = i; j >= gap && nums[j - gap].compareTo(tmp) > 0; j -= gap)
                    nums[j] = nums[j - gap];
                nums[j] = tmp;
            }
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
