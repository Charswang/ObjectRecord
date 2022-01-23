package leetcode;

/**
 * 双指针
 */
public class P283_UNFINISH {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        // 始终让i指向元素为0的index处，j循环，当nums[j]>0的时候就更换，不然就只往后移动j
        while(j<nums.length){
            if(nums[j]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
    }
}
