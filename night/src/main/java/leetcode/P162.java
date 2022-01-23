package leetcode;

/**
 * 2021-9-15
 * 寻找峰值;时间复杂度为O(log n)
 */
public class P162 {
    public static void main(String[] args) {

    }
    // 画一个具有极大值的函数，观察他的峰值；
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int middle = left + (right-left)/2;
            if (nums[middle]>nums[middle+1]){
                right=middle;
            }else{
                left = middle+1;
            }
        }
        return left;
    }
    public static int findPeakElement2(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int middle = 0;
        while(left<=right){
            middle = left + (right-left)/2;
            if ((middle-1)>=0 && (middle+1<right) && nums[middle]>nums[middle-1] && nums[middle]>nums[middle+1]){
                return middle;
            }else if (nums[middle]>nums[middle+1]){
                right=middle;
            }else{
                left = middle+1;
            }
        }
        return middle;
    }
}
