package sort;

import java.util.Random;

/**
 * 冒泡排序
 * 排序时间 1535857 纳秒
 */
public class BubbleSort {

    public static <T extends Comparable<? super T>> void sort(T[] nums) {

        if (nums == null || nums.length == 0)
            throw new NullPointerException("没有值啊 兄弟");

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j].compareTo(nums[j + 1]) > 0) {
                    CommonUtil.swap(nums, j, j + 1);
                }
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
