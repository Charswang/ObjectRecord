package leetcode;

/**
 * 2022-1-12
 * 每日一题
 *
 * 得看最长递增子序列
 */
public class P334_UNFINISHED {
    /**
     * 玄学解答
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for(int num : nums){
            if(num<=a){
                a = num;
            }else if(num<=b){
                b = num;
            }else{
                return true;
            }
        }
        return false;
    }
}
