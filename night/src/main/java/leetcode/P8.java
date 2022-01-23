package leetcode;

import java.math.BigInteger;

/**
 * 8、字符串转换整数 (atoi)
 * @author charswang
 * @date 2021-08-14
 *
 * -- 暴力法，直接使用BigInteger覆盖，然后进行判断。
 * 执行用时：6 ms, 在所有 Java 提交中击败了10.83%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了26.88%的用户
 *
 * 此方法较烂，需进一步理解题解。
 * 需要进一步尝试使用**自动机？？**方式
 */
public class P8 {
    public int myAtio(String s) {
//        int res = 0;
        StringBuffer sb = new StringBuffer("");
        // 1、去除空格
        s = s.trim();
        if(s.length()==0){
            return 0;
        }
        // 2、判断正负
        if (s.charAt(0) == '-' || s.charAt(0) == '+' || Character.isDigit(s.charAt(0))){
            sb.append(s.charAt(0));
            for (int i = 1;i < s.length();i++){
                if (Character.isDigit(s.charAt(i))){
                    sb.append(s.charAt(i));
                }else{
                    break;
                }
            }
        }
        if (sb.toString().length()==0){
            return 0;
        }
        if (sb.toString().length()==1){
            if (sb.charAt(0) == '-' || sb.charAt(0) == '+'){
                return 0;
            }
        }
        BigInteger bigInteger = new BigInteger(sb.toString());
        if (bigInteger.compareTo(BigInteger.valueOf(Integer.MIN_VALUE))==1 && bigInteger.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))==-1){
            return bigInteger.intValue();
        }else{
            if (bigInteger.compareTo(BigInteger.ZERO)==1){
                return Integer.MAX_VALUE;
            }else {
                return Integer.MIN_VALUE;
            }
        }
    }
}
