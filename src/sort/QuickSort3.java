package sort;

import java.util.Random;

public class QuickSort3 {

    private static final int CUTOFF = 3;

    //三值取中  我的这个算法不需要大幅度改变原来的快排 取完的中值直接放在low位置
    private static <T extends Comparable<? super T>> T median3(T[] nums , int low , int hi){

        int center = (low + hi )/2;

        if(nums[low].compareTo(nums[center]) > 0)
            swap(nums , low , center);

        if(nums[center].compareTo(nums[hi]) > 0)
            swap(nums , center , hi);

        //这里的<时交换是使中值放在low处 因此原来的快排步骤基本不变
        if(nums[low].compareTo(nums[center]) < 0)
            swap(nums , low , center);

        return nums[low];
    }

    //插入排序
    private static <T extends Comparable<? super T>> void insertionSort(T[] nums, int le, int ri) {

        for (int i = le + 1; i <= ri; i++) {
            T tmp = nums[i];
            int j;
            for (j = i; j > le && tmp.compareTo(nums[j - 1]) < 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = tmp;
        }
    }

    private static <T extends Comparable<? super T>> void swap(T[] nums, int i, int j) {
        T tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static <T extends Comparable<? super T>> int partition(T[] nums, int low, int hi) {

        //T p = nums[low];
        T p = median3(nums , low , hi);
        hi = hi -1;

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
        if (low + CUTOFF <= hi) {
            int re = partition(nums, low, hi);
            sort(nums, low, re - 1);
            sort(nums, re + 1, hi);
        } else {
            //这里使用另一个类中的插入排序会慢很多???(我觉得可能是类加载时间???)
            //InsertionSort.sort(nums , low , hi);
            insertionSort(nums, low, hi);
        }
    }

    public static <T extends Comparable<? super T>> void sort(T[] nums) {

        if (nums == null || nums.length == 0) {
            throw new NullPointerException("no numbers");
        }

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
