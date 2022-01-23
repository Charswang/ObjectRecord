package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021-12-22
 * 每日一题
 *
 * 首先求最小重复次数就说明，可以先将b的首字母在a中出现的位置都保存下来到list，
 * 然后从前往后遍历list，直到符合条件的时候退出；【因为a中开始的位置越靠前，就说明重复次数越少】；
 *
 * 判断是否符合条件：首先判断b的长度是否>a中开始的位置到a的结尾的长度,如果大于的话，说明重复次数>1，
 * 然后获取a中开始的位置到结尾的子串①，b的长度减去①的长度之后 / a的长度 ②【②说明，完全使用a整个字符串的次数】，b的长度减去①的长度之后
 * a的长度 ③【最后剩余匹配的子串】；三个子串结合，看是否equals b；如果相同则return，否则往后继续遍历；
 * 如果b的长度是否<a中开始的位置到a的结尾的长度, 则直接从a的开始位置与b的第一个字母开始往后遍历，如果相同则return，否则继续往后便利
 */
public class P686 {
    public int repeatedStringMatch(String a, String b) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < a.length();i++){
            if (a.charAt(i)==b.charAt(0)){
                list.add(i);
            }
        }
        int res = -1;
        int blen = b.length();
        int alen = a.length();
        for (Integer integer : list) {
            StringBuffer sb = new StringBuffer("");
            int l = alen-integer;
            if (blen>l){
                int p = blen-l;
                int q = p/alen;
                int r = p%alen;
                sb.append(a.substring(integer));
                for (int j = 0;j < q;j++){
                    sb.append(a);
                }
                sb.append(a.substring(0,r));
                if (b.equals(sb.toString())){
                    res = r>0?(q+2):(q+1);
                    return res;
                }
            }else {
                String substring = a.substring(integer, integer + blen);
                if (substring.equals(b)){
                    return 1;
                }
            }

        }
        return -1;
    }
}
