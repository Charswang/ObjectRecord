package leetcode.SwordOffer;

import java.util.Arrays;

/**
 * 2022-1-2
 */
public class SwordOfferII004 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==1 || nums[0]!=nums[1]){
            return nums[0];
        }
        for(int i = 1;i < nums.length-1;i++){
            if(nums[i]!=nums[i-1] && nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}
