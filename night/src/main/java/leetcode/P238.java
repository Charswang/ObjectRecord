package leetcode;

/**
 * 2021-11-12
 */
public class P238 {
    public int[] productExceptSelf(int[] nums) {
        int[] dp1 = new int[nums.length-1];
        int[] dp2 = new int[nums.length-1];
        int res1 = 1;
        int res2 = 1;
        for (int i = 0;i < nums.length-1;i++){
            dp1[i] = res1 * nums[i];
            res1 = res1 * nums[i];
        }
        int count = 0;
        for (int i = nums.length-1;i>0;i--){
            dp2[count] = res2 * nums[i];
            res2 = res2 * nums[i];
            count++;
        }
        int[] res = new int[nums.length];
        res[0] = dp2[nums.length-2];
        res[res.length-1]=dp1[nums.length-2];;
        for (int i = 1;i < res.length-1;i++){
            res[i] = dp1[i-1] * dp2[nums.length-2-i];
        }
        return res;
    }
    public int[] productExceptSelf1(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        /*for (int i = 0;i < nums.length;i++){
            dp[i][0]=1;
            dp[0][i]=1;
            dp[i][i]=nums[i];
        }*/
        for (int i = 0;i<nums.length;i++){
            for (int j = i;j>=0;j--){
                dp[j][i]=dp[j+1][i]*nums[j];
            }
        }
        int[] res = new int[nums.length];
        for (int i = 1;i <= res.length;i++){
            if (i==res.length){
                res[i-1]=dp[1][i-1];
                break;
            }
            int a = i-1;
            if (a<1){
                res[i-1]=dp[i+1][nums.length];
            }else{
                res[i-1]=dp[1][i-1]*dp[i+1][nums.length];
            }
        }
        return res;
    }
}
