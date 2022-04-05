package leetcode;

import java.util.Stack;

/**
 * 2022-3-7
 * 每日一题
 */
public class P504_进制转换 {
    public String convertToBase7(int num) {
        if(num==0){
            return "0";
        }
        boolean flag = true;
        if (num<0){
            num = -num;
            flag = false;
        }
        StringBuffer sb = new StringBuffer();
        while (num>0){
            sb.insert(0,num%7);
            num = num / 7;
        }
        if (!flag){
            sb.insert(0,'-');
        }
        return sb.toString();
    }
}
