package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022-1-2
 * 自己的这个代码太烂了。。。
 *
 * 最后面有个别人的。
 */
public class P5968_U {
    public int numberOfBeams(String[] bank) {
        List<Integer> list = new ArrayList<>();
        for (String s : bank) {
            int compute = compute(s);
            if (compute>0){
                list.add(compute);
            }
        }
        if (list.size()<=1){
            return 0;
        }
        int res = 0;
        for (int i = 0;i < list.size()-1;i++){
            res += list.get(i)*list.get(i+1);
        }
        return res;
    }
    public int compute(String str){
        int sum = 0;
        for (int i = 0;i < str.length();i++){
            if (str.charAt(i)=='1'){
                sum++;
            }
        }
        return sum;
    }

    public int numberOfBeams2(String[] bank) {
        int res = 0, pre = 0, cnt = 0;
        for (String s : bank){
            cnt = 0;
            for (int i=0; i < s.length(); i++){
                if (s.charAt(i) == '1') cnt++;
            }
            if (cnt > 0){
                res += pre * cnt;
                pre = cnt;
            }
        }
        return res;
    }
}
