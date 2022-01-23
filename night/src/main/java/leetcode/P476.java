package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021-10-18
 * 每日一题
 */
public class P476 {
    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }
    public static int findComplement(int num) {
        List<Integer> list = new ArrayList<Integer>();
        while(num>=1){
            int a = num / 2;
            int b = num % 2;
            list.add(b);
            num = a;
        }
        int len = list.size();
        int res = 0;
        for (int i = 0;i<len;i++){
            int c = (list.get(i))==1?0:1;
            res += Math.pow(2,i) * c;
        }
        return res;
    }
}
