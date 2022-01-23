package leetcode;

/**
 * 不使用除法，进行两数相除
 * 2021-9-23提交  答案。。
 */
public class P29_unfinish {
    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = -1;
        System.out.println(divide(dividend, divisor));
    }

    /*public static int divide(int dividend, int divisor) {
        boolean flag = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = false;
        }
        if (divisor == -1) {
            if (dividend <= Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }
        }
        dividend = dividend > 0 ? dividend : -dividend;
        divisor = divisor > 0 ? divisor : -divisor;
        System.out.println(dividend);
        System.out.println(divisor);
        int res = dg(dividend, divisor);
        if (flag == true) {
            res = res > Integer.MAX_VALUE ? Integer.MAX_VALUE : res;
        }
        if (flag == false) {
            res = res < Integer.MIN_VALUE ? Integer.MAX_VALUE : res;
        }
        return res;
    }

    public static int dg(int dividend, int divisor) {
        if (dividend < divisor) {
            return 0;
        }
        int count = 1;
        int all = divisor;
        while (all < dividend) {
            if (all + all < dividend) {
                count++;
                all += all;
            } else {
                break;
            }
        }
        return count + dg(dividend - all, divisor);
    }*/
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        negative = (dividend ^ divisor) <0;//用异或来计算是否符号相异
        long t = Math.abs((long) dividend);
        long d= Math.abs((long) divisor);
        int result = 0;
        for (int i=31; i>=0;i--) {
            if ((t>>i)>=d) {//找出足够大的数2^n*divisor
                result+=1<<i;//将结果加上2^n
                t-=d<<i;//将被除数减去2^n*divisor       d * 2的i次方
            }
        }
        return negative ? -result : result;//符号相异取反
    }
}
