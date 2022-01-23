package leetcode;

public class P35 {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        System.out.println(searchInsert(nums, target));
    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int middle = left + (right - left) / 2;
            if (nums[middle]==target){
                return middle;
            }else if (nums[middle]>target){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }
        if (nums[left]==target){
            return left;
        }
        if (nums[left] > target){
            return left;
        }else{
            return left + 1;
        }
    }
}
