package leetcode;

public class P33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {
        if(nums[0]>target){
            for(int i = nums.length-1;i>=0;i--){
                if(nums[i]==target){
                    return i;
                }
                if(nums[i]<target || nums[i]>nums[0]){
                    return -1;
                }
            }
        }else{
            for(int i = 0;i<nums.length;i++){
                if(nums[i]==target){
                    return i;
                }
                if(nums[i]>target){
                    return -1;
                }
            }
        }
        return -1;
    }
}
