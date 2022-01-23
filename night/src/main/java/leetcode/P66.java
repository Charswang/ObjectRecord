package leetcode;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 2021-10-21
 * 每日一题
 */
public class P66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int jinwei = 1;
        for (int i = len-1;i >=0;i--){
            int a = digits[i] + jinwei;
            jinwei = a/10;
            digits[i] = a%10;
        }
        if (jinwei>0){
            int[] res = new int[len+1];
            res[0] = jinwei;
            for (int i = 1;i<=len;i++){
                res[i] = digits[i-1];
            }
            return res;
        }
        return digits;
    }
}
