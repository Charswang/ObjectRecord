package leetcode.competition.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2022-4-17
 *
 * 6062. 设计一个 ATM 机器
 *
 * 做了很长时间，明明是很简单的题目，为什么就是想不明白简单的思路呢，这里是别人的。。。。。。
 */
public class P6062_Mistake {

}
class ATM {

    private long[] banknotes = new long[5];
    private int[] a = new int[]{20,50,100,200,500};
    public ATM() {

    }

    public void deposit(int[] banknotesCount) {
        for (int i=0; i<5; i++) {
            banknotes[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] res = new int[5];

        for (int i=4; i>=0; --i) {
            int count = (int) Math.min(amount/a[i], banknotes[i]);
            res[i] = count;
            amount -= a[i]*count;
        }

        if (amount != 0) {
            return new int[]{-1};
        }

        for (int i = 0; i < 5; ++i) {
            banknotes[i] -= res[i];
        }

        return res;
    }
}
