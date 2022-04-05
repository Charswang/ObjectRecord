package leetcode;

/**
 * 2022-4-5
 * 每日一题
 */
public class P762 {
    public static void main(String[] args) {
        System.out.println(1>>1);
    }
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        // 计算num的二进制有几个1
        for (int i = left; i <= right; i++) {
            int temp = i;
            int sum = 0;
            while (temp > 0) {
                if ((temp & 1) == 1) {
                    sum++;
                }
                temp = temp >> 1;
            }
            if (isPrime(sum)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isPrime(int num) {
        if (num == 1 || num == 0) {
            return false;
        }
        double sqrt = Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
