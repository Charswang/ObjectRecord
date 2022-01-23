package leetcode;

/**
 * 2021-9-19
 */
public class P650_UN {
    public static void main(String[] args) {
        System.out.println(minSteps_answer(100)==minSteps(100));
    }

    public static int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2;i <=n;i++){
            dp[i] = i; // 每个位置最多的操作次数；
            // j>=1 / j>1都一样
            for (int j = i/2;j>1;j--){
                if (i%j==0){
                    dp[i] = dp[j] + i/j;
                    break;
                }
            }
        }
        return dp[n];
    }
    public static int minSteps_answer(int n) {
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                if (i % j == 0) {
                    f[i] = Math.min(f[i], f[j] + i / j);
                    f[i] = Math.min(f[i], f[i / j] + j);
                }
            }
        }
        return f[n];
    }
}
