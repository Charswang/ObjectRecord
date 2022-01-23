package leetcode;

/**
 * 采用二分，可以指数级减少运算时间复杂度
 */
public class P50 {
    public static void main(String[] args) {
        double x = 2.0000;
        int n = -2;
        double v = n >= 0 ? myPow(x, n) : 1 / myPow(x, -n);
        System.out.println(v);
    }

    public static double myPow(double x, int n) {
        // StackOverFlowError
        /*if (n==0){
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n<0){
            return (1/x) * myPow(1/x,-(n+1));
        }
        return x * myPow(x, n - 1);*/
        if (n == 0) {
            return 1;
        }
        double y = myPow(x, n / 2);
        return y % 2 == 0 ? y * y : y * y * x;
    }
}
