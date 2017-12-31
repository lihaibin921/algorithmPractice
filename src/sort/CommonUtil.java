package sort;

public class CommonUtil {

    /**
     * 交换
     */
    public static <T extends Comparable<? super T>> void swap(T[] nums, int i, int j) {
        T tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
