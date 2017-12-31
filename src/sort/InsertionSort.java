package sort;

import java.util.Random;

/**
 * 插入排序
 * 排序时间 321047 纳秒
 */
public class InsertionSort {

    public static <T extends Comparable<? super T>> void sort(T[] nums , int le , int ri) {

        if (nums == null || nums.length == 0)
            throw new NullPointerException("没有值啊 兄弟");

        for (int i = le; i <= ri; i++) {
            T tmp = nums[i];
            int j;
            for (j = i; j > le && nums[j - 1].compareTo(tmp) > 0; j--)
                nums[j] = nums[j - 1];
            nums[j] = tmp;
        }
    }

    public static <T extends Comparable<? super T>> void sort(T[] nums ) {
        sort(nums , 0 , nums.length - 1);
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
