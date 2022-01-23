package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 201-12-21
 * 每日一题
 */
public class P1154 {
    public int dayOfYear(String date) {
        String[] split = date.split("-");
        int res = 0;
        // 判断是否为闰年
        int year = Integer.parseInt(split[0]);
        boolean y_flag = false;
        if ((year%4==0 && year%100!=0) || year%400==0){
            y_flag=true;
        }
        // 判断当前月之前的所有天数
        List<Integer> month_31 = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
        int month = Integer.parseInt(split[1]);
        for (int i = month-1;i>0;i--){
            if (month_31.contains(i)){
                res+=31;
            }else if (i==2){
                if (y_flag){
                    res+=29;
                }else{
                    res+=28;
                }
            }else{
                res+=30;
            }
        }
        // 加上当前月经过的天数
        return res+Integer.parseInt(split[2]);
    }
}
