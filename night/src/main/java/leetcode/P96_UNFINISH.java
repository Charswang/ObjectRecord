package leetcode;

public class P96_UNFINISH {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        // G(n) = G(0)*G(n-1) + G(1)*G(n-2) + ... + G(n-1)*G(0)
        // 左边0个，右边n-1个的时候有几种，......
        for (int i = 2;i <= n;i++){
            for (int j = 0;j<i;j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
}
