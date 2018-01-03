package search;

import java.util.Arrays;
import java.util.Random;

/**
 * 二分查找
 */
public class BinarySearch {

    public static int binarySearch(int[] nums , int key){

        if(nums == null || nums.length == 0)
            return -1;

        int low = 0;
        int hi = nums.length - 1;
        int mid = 0;

        while(low <= hi){
            mid = (low + hi) / 2;
            if(key < nums[mid]){
                hi = mid -1;
            }else if(key > nums[mid]){
                low = mid + 1;
            }else{
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = new int[100];

        Random r = new Random(53);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(999);
        }

        Arrays.sort(nums);

        for(int i : nums){
            System.out.print(i + " , ");
        }

        System.out.println();

        int key = 13;
        int re = binarySearch(nums, key);

        if(re != -1){
            System.out.println(re + " " + nums[re]);
        }else{
            System.out.println("找不到");
        }

    }

}
