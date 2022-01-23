package leetcode;

/**
 * 2021-11-16
 * 每日一题
 */
public class P279 {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        int min = Integer.MAX_VALUE;
        int a = (int) Math.sqrt(n);
        for (int i = a; i >= 1; i--) {
            int res = 0;
            int aa = i * i;
            if (n % aa == 0) {
                res = n / aa;
                min = res < min ? res : min;
                break;
            } else {
                res = n / aa + numSquares(n % aa);
            }
            min = res < min ? res : min;

        }
        return min;
    }
}
