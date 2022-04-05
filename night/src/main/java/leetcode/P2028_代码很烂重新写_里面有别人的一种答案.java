package leetcode;

import java.util.Arrays;

/**
 * 2022-3-27
 * 每日一题
 */
public class P2028_代码很烂重新写_里面有别人的一种答案 {
    public static void main(String[] args) {
        int[] a = {1,5,6};
        int[] ints = missingRolls(a, 3, 4);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] missingRolls2(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = 0;
        for (int r : rolls) {
            sum += r;
        }

        int x = mean * (m + n) - sum;

        if (x < 1*n || x > 6*n) return new int[]{};
        int[] ans = new int[n];
        int each = x / n;
        int resi = x - each * n;
        for (int i = 0; i < n; ++i) {
            ans[i] = each + (resi > 0 ? 1 : 0);
            resi--;
        }
        return ans;
    }
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int len = rolls.length + n; // n+m个数
        int sum = mean * len; // n+m个总和
        int remain = sum - Arrays.stream(rolls).sum(); // n个总和
        if ((remain * 1.0 / n) > 6.0 || (remain * 1.0 / n) < 1.0) {
            return new int[0];
        }
        // 主要在怎么把剩余的总和分给n个数
        int[] res = new int[n];
        int temp = (int) Math.ceil(remain * 1.0 / n);
        for (int i = 0; i < n; i++) {
            int a = temp;
            while (res[i] == 0) {
                int i1 = remain - a;
                int i2 = n - i - 1;
                if (i1==0 && i2==0){
                    res[i] = a;
                    break;
                }
//                double v = i1 * 1.0 / i2;
                if (i1>=i2 && i1 <=6*i2){
                    res[i] = a;
                    remain = remain - a;
//                    System.out.println(res[i]);
                    break;
                }else{
                    a--;
                }
            }
//            System.out.println("1");
        }

        return res;
    }
}
