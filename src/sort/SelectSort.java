package sort;

import java.util.Random;

/**
 * 选择排序
 * 排序时间 1395861 纳秒
 */
public class SelectSort {
    public static <T extends Comparable<? super T>> void sort(T[] nums) {

        if (nums == null || nums.length == 0)
            throw new NullPointerException("没有值啊 兄弟");

        for (int i = 0; i < nums.length; i++) {
            T min = nums[i];
            int k = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j].compareTo(min) < 0) {
                    min = nums[j];
                    k = j;
                }
            }
            if (k != i) {
                CommonUtil.swap(nums, k, i);
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
