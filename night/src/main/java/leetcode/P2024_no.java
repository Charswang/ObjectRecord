package leetcode;

import java.util.Date;

/**
 * 2022-3-29
 * 每日一题
 */
public class P2024_no {
    public static void main(String[] args) {
        // 获取ms
        long ms_start = System.currentTimeMillis();
        System.out.println("获取ms");
        long ms_end = System.currentTimeMillis();
        System.out.println("ms = " + (ms_end-ms_start));

        System.out.println("==========================================================");

        // 这是纳秒吧。。。。。
        long us_start = System.nanoTime();
        System.out.println("获取us");
        long us_end = System.nanoTime();
        System.out.println("us = " + (us_end-us_start));

        long us_start2 = System.nanoTime();
        System.out.println("获取us");
        long us_end2 = System.nanoTime();
        System.out.println("us = " + (us_end2-us_start2));
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int len = answerKey.length();
        int[][] dpTrue = new int[len][len];
        int[][] dpFalse = new int[len][len];
        if (answerKey.charAt(0) == 'T') {
            dpTrue[0][0] = 1;
        } else {
            dpFalse[0][0] = 1;
        }
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (answerKey.charAt(i) == 'T') {
                    dpTrue[j][i] = dpTrue[j][i - 1] + 1;
                    dpFalse[j][i] = dpFalse[j][i-1];
                    if (k >= (i - j + 1 - dpTrue[j][i])) {
                        max = Math.max(max, i - j + 1);
                    }
                } else {
                    dpFalse[j][i] = dpFalse[j][i - 1] + 1;
                    dpTrue[j][i] = dpTrue[j][i-1];
                    if (k >= (i - j + 1 - dpFalse[j][i])) {
                        max = Math.max(max, i - j + 1);
                    }
                }
            }
        }
        return max;
    }
}
