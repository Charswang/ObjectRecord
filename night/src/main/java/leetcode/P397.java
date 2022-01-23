package leetcode;

import java.util.Set;

/**
 * 2021-11-19
 * 每日一题
 */
public class P397 {

    public static void main(String[] args) {
        int[] num = {1,2,3,4,4,5,6,5,5};
        int[] dp = new int[num.length];
        for (int i = 2;i < num.length;i++){
            int a = num[i]==num[i-1]?1:0;
            int b = num[i]==num[i-2]?1:0;
            int d = num[i-1]==num[i-2]?1:0;
            dp[i]=3-a-b-d;
        }
        for (int i = 2;i < num.length;i++){
            System.out.println(dp[i]);
        }
    }
    public int func(int n ){
        return integerReplacement(n);
    }
    public int integerReplacement(int n) {
        if (n==1){
            return 0;
        }
        if (n%2==0){
            return 1+integerReplacement(n/2);
        }else{
            return Math.min(1+integerReplacement(n-1),1+integerReplacement(n+1));
        }
    }
    public int integerReplacement1(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=0;
        for (int i = 2;i <= n;i++){
            if (i%2==0){
                dp[i] = dp[i/2]+1;
            }else{
                dp[i] = Math.min(dp[i-1]+1,dp[(i+1)/2+2]);
            }
        }
        return dp[n];
    }
}
