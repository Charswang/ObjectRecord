package leetcode;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.XML11IDDatatypeValidator;

public class P35_NO2 {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        System.out.println(searchInsert(nums, target));
    }

    public int searchInsertForTwo(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                ans = middle;
                right = middle - 1;
            }
        }
        return ans;
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[left] > target) {
            return left;
        } else {
            return left + 1;
        }
    }
}
